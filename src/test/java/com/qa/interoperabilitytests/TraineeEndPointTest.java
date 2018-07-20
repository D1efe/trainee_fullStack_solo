package com.qa.interoperabilitytests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.interoperability.TraineeEndPoint;
import com.qa.persistence.ITrainee;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndPointTest {

	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	private static final Long MOCK_ID = 1L;


	@InjectMocks
	private TraineeEndPoint endpoint;

	@Mock
	private ITrainee service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAllAccounts() {
		Mockito.when(service.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllTrainees());
	}

	@Test
	public void testCreateAccount() {
		Mockito.when(service.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createTrainee(MOCK_VALUE2));
		Mockito.verify(service).createTrainee(MOCK_VALUE2);
	}

	@Test
	public void testUpdateAccount() {
		Mockito.when(service.updateTrainee(MOCK_ID, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.updateTrainee(MOCK_ID, MOCK_VALUE2));
		Mockito.verify(service).updateTrainee(MOCK_ID, MOCK_VALUE2);
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(service.deleteTrainee(MOCK_ID)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteTrainee(MOCK_ID));
		Mockito.verify(service).deleteTrainee(MOCK_ID);
	}

}
