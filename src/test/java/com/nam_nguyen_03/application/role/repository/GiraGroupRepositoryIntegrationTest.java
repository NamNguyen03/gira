package com.nam_nguyen_03.application.role.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nam_nguyen_03.application.role.model.GiraGroup;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

/**
 * @author nam
 *
 */
@SpringBootTest
@Transactional
public class GiraGroupRepositoryIntegrationTest {
    
    @Autowired
    private GiraGroupRepo repo;

    @Test
    public void whenGiraGroupInvalidIsUsedToSave_thenThrowException(){
        GiraGroup giraGroup = GiraGroup.builder()
				.code("1")
				.description("description")
				.build();
		assertThrows(Exception.class, () -> repo.saveAndFlush(giraGroup), "length code should to 3 from 30 character");

		GiraGroup giraGroup2 = GiraGroup.builder()
				.code("1234")
				.description(null)
				.build();
		assertThrows(Exception.class, () -> repo.saveAndFlush(giraGroup2), "description should be not null");

    }

    @Test
    public void whenGiraRoleValid_thenSaveGiraRoleSuccess(){
        GiraGroup giraGroup = GiraGroup.builder()
				.code("1456")
				.description("description")
				.build();
		assertDoesNotThrow(()-> repo.saveAndFlush(giraGroup));
    }

}
