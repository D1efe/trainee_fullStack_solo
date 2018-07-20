package com.qa.persistencetests;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.domain.Trainee;
import com.qa.persistence.TraineeDBRepository;
import com.qa.utility.JSONUtility;;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {

	@InjectMocks
	private TraineeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtility util;

	private static final String MOCK_DATA_ARRAY = "[{\"fName\":\"Daniel\",\"lName\":\"Osagie\",\"startMonth\":\"June\"}]";
	private static final String MOCK_OBJECT = "{\"fName\":\"Daniel\",\"lName\":\"Osagie\",\"startMonth\":\"June\"}";
	private static final Long MOCK_ID = 1L;

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtility();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(new Trainee("Daniel", "Osagie", "June"));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}

	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, MOCK_OBJECT);
	}

	@Test
	public void testUpdateTrainee() {
		String reply = repo.updateTrainee(1L, MOCK_OBJECT);
		System.out.println(reply);
		Assert.assertEquals(reply, "{\"message\": \"account has been sucessfully added\"}");
	}

	@Test
	public void testDeleteTrainee() {
		String reply = repo.deleteTrainee(1L);
		Assert.assertEquals(reply, repo.deleteTrainee(MOCK_ID));
	}

}
