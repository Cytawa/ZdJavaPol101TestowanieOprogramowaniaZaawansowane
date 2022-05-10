package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    private static final Animal ANIMAL= new Animal(10L, "kot", "Filemon");

@Mock
private AnimalRespository animalRespository;
@InjectMocks
    private AnimalService animalService;

@Test
void shouldReturnAnimalById(){
    //given
    Mockito.when(animalRespository.findById(10L)).thenReturn(Optional.of(ANIMAL));
    //when
    Animal result = animalService.getById(10L);
    //then
    assertEquals(ANIMAL, result);
}
}