package com.feedback.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.feedback.dao.FeedbackDao;
import com.feedback.dto.DropdownDTO;
import com.feedback.dto.EmployeeDTO;
import com.feedback.dto.MyReviewsDTO;
import com.feedback.entities.Participant;
import com.feedback.entities.Role;
import com.feedback.entities.UserRole;
import com.feedback.entities.Users;
import com.feedback.jpa.repositories.ParticipantRepository;
import com.feedback.jpa.repositories.RoleRepository;
import com.feedback.jpa.repositories.UsersRepository;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	private EntityManager entityManager;

	@Autowired
	public FeedbackDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Autowired
	private ParticipantRepository participantRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public List<MyReviewsDTO> getMyReviews(String userName) {

		String sql = "select pat.id participant_id, fbk.feedback_name,  usr1.full_name reviewee_name, usr1.email reviewee_email, pat.comments, "
				+ "		pat.rating, pat.status, pat.assign_date " + "from users usr inner join  participants pat  on "
				+ "usr.id = pat.participant_id inner join feedback_participants fkp on "
				+ "pat.id = fkp.participant_id inner join feedback fbk on fkp.feedback_id = fbk.id inner join users usr1 on usr1.id = fbk.reviewee_id "
				+ "where usr.user_name = ? and pat.status = 'Pending'";

		return jdbcTemplate.query(sql, new Object[] { userName },
				(rs, rowNum) -> new MyReviewsDTO(rs.getLong("participant_id"), rs.getString("feedback_name"),
						rs.getString("reviewee_name"), rs.getString("reviewee_email"), rs.getString("comments"),
						rs.getString("rating"), rs.getString("status"), rs.getDate("assign_date")));

	}

	@Override
	public void saveReviews(MyReviewsDTO myReviews) {

		Optional<Participant> participants = participantRepository.findById(myReviews.getParticipantId());
		participants.ifPresent(particpant -> {
			particpant.setComments(myReviews.getComments());
			particpant.setRating(myReviews.getRating());
			particpant.setStatus("Completed");
			particpant.setCompleteDate(new Date());
			participantRepository.save(particpant);
		});

	}

	public List<DropdownDTO> getReviewersForUser(int userId) {
		String sql = "select distinct concat(usr.first_name, ' ', usr.last_name) name, usr.id value from users usr"
				+ " left join user_roles uro on" + " usr.id = uro.user_id" + " left join Roles rol on"
				+ " uro.role_id = rol.id" + " left join reviews rev on" + " usr.id = rev.reviewer_id" + " WHERE"
				+ " usr.status = 'Active'" + " and usr.id <> ?" + " and rev.status <> 'pending' or rev.status is null";

		return jdbcTemplate.query(sql, new Object[] { userId },
				(rs, rowNum) -> new DropdownDTO(rs.getString("name"), rs.getLong("value")));
	}

	public List<DropdownDTO> getUsersForReview() {
		String sql = "select concat(usr.first_name, ' ', usr.last_name) name, usr.id value from users usr, user_roles uro, roles rol"
				+ " where usr.id = uro.user_id and usr.status = 'Active' and uro.role_id = rol.id and rol.role_name <> 'Admin'";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new DropdownDTO(rs.getString("name"), rs.getLong("value")));
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		String sql = "select usr.first_name, usr.last_name, usr.id, usr.email from users usr, user_roles uro, roles rol"
				+ " where usr.id = uro.user_id and usr.status = 'Active' and uro.role_id = rol.id and rol.role_name <> 'Admin'";

		return jdbcTemplate.query(sql, (rs, rowNum) -> new EmployeeDTO(rs.getLong("id"), rs.getString("first_name"),
				rs.getString("last_name"), rs.getString("email")));
	}

	@Override
	public String addEmployee(EmployeeDTO employee) {
		String retStr = "";
		Users users = usersRepository.findByUserNameAndStatus(employee.getUserName(), "Active");
		if (users != null) {
			retStr = "User Name Already Exists";
		} else {
			Users user = new Users();
			user.setUserName(employee.getUserName());
			user.setPassword(bcryptEncoder.encode(employee.getPassword()));
			user.setEmail(employee.getEmail());
			user.setFirstName(employee.getFirstName());
			user.setLastName(employee.getLastName());
			user.setStatus("Active");

			Role role = roleRepository.findByRoleDesc("Employee");
			UserRole userRoles = new UserRole();
			userRoles.setRole(role);
			Set<UserRole> userRoleList = new HashSet<UserRole>(); 
			userRoles.setUsers(user);
			userRoleList.add(userRoles);
			user.setUserRoles(userRoleList);

			// user.addUserRole(userRoles);

			Users svaedUser = usersRepository.save(user);
			if (svaedUser != null) {
				retStr = "Saved";
			}
		}
		return retStr;
	}
	
	@Override
	public void editEmployee(EmployeeDTO employee) {
		Optional<Users> users = usersRepository.findById(employee.getId());
		users.ifPresent(user -> {
			user.setEmail(employee.getEmail());
			user.setFirstName(employee.getFirstName());
			user.setLastName(employee.getLastName());		
			usersRepository.save(user);
		});
	}
	
	@Override
	public void deleteEmployee(EmployeeDTO employee) {
		Optional<Users> users = usersRepository.findById(employee.getId());
		users.ifPresent(user -> {
			user.setStatus("Inactive");
			usersRepository.save(user);
		});
	}
	
}
