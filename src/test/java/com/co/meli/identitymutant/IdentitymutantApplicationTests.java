package com.co.meli.identitymutant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class IdentitymutantApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void testValidateMutantPositive() throws Exception {
		/*IndentifyMutantService service = new IndentifyMutantService();
		String test[] = {"CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG","AAAAAA"};
		String idApp = "Magneto";
		RequestChainMutantDTO dto =  new RequestChainMutantDTO(idApp,test);
		boolean result = service.validateMutant(dto);
		assertTrue(result);*/
	}

	@Test
	public void testValidateMutantNegative() throws Exception {
		/*IndentifyMutantService service = new IndentifyMutantService();
		String test[] = {"MBNTGC","TTATGT","AGAAGG","ACCCTA","TCACTG","GAGAAA"};
		String idApp = "Magneto";
		RequestChainMutantDTO dto =  new RequestChainMutantDTO(idApp,test);
		boolean result = service.validateMutant(dto);
		assertFalse(result);*/
	}
}
