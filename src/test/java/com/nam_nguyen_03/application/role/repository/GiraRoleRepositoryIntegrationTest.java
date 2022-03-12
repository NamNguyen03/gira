/**
 * 
 */
package com.nam_nguyen_03.application.role.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nam_nguyen_03.application.role.model.GiraRole;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;
/**
 * @author nam
 *
 */

@SpringBootTest
@Transactional
public class GiraRoleRepositoryIntegrationTest  {

	@Autowired
	private GiraRoleRepo repo;

	@Test
	public void whenGiraRoleInvalidIsUsedToSave_thenThrowException() {
		GiraRole giraRole = GiraRole.builder()
				.code("1")
				.description("description")
				.build();
		assertThrows(Exception.class, () -> repo.saveAndFlush(giraRole), "length code should to 3 from 30 character");

		GiraRole giraRole2 = GiraRole.builder()
				.code("1234")
				.description(null)
				.build();
		assertThrows(Exception.class, () -> repo.saveAndFlush(giraRole2), "description should be not null");
	}

	@Test
	public void whenGiraRoleValid_thenSaveGiraRoleSuccess(){
		GiraRole giraRole = GiraRole.builder()
				.code("1456")
				.description("description")
				.build();
		assertDoesNotThrow(()-> repo.saveAndFlush(giraRole));
	}
}
