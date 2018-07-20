package com.qa.businesstests;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.TraineeService;
import com.qa.persistence.ITrainee;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	@InjectMocks
	private TraineeService service;

	@Mock
	private EntityManager manager;

	@Mock
	private ITrainee repo;

	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	private static final Long MOCK_ID = 1L;

	@Before
	public void setup() {
		service.setRepo(repo);
	}

	@Test
	public void testGetAllTrainees() {
		Mockito.when(repo.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getAllTrainees());
	}

	@Test
	public void testCreatetrainee() {
		Mockito.when(repo.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.createTrainee(MOCK_VALUE2));
		Mockito.verify(repo).createTrainee(MOCK_VALUE2);
	}

	@Test
	public void testUpdatetrainee() {
		Mockito.when(repo.updateTrainee(MOCK_ID, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.updateTrainee(MOCK_ID, MOCK_VALUE2));
		Mockito.verify(repo).updateTrainee(MOCK_ID, MOCK_VALUE2);
	}

	@Test
	public void testDeletetrainee() {
		Mockito.when(repo.deleteTrainee(MOCK_ID)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.deleteTrainee(1L));
		Mockito.verify(repo).deleteTrainee(1L);
	}

}
