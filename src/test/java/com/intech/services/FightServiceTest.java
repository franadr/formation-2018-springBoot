package com.intech.services;

import com.intech.api.FightResponse;
import com.intech.converters.SuperheroConverter;
import com.intech.model.Superhero;
import com.intech.repositories.SuperheroRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FightServiceTest {
    private SuperheroRepository repository;
    private SuperheroConverter converter;
    private FightService fightService;
    private Random random;
    @Before
    public void setUp() throws Exception {

        converter = new SuperheroConverter();
        repository = mock(SuperheroRepository.class);
        random = mock(Random.class);
        fightService = new FightService(repository,converter);
    }

    @Test
    public void test_StartsuperHeroFight(){
        Superhero batman = Superhero.builder()
                .idHero(1L)
                .heroName("batman")
                .strength(100)
                .durability(100)
                .build();
        Superhero superman = Superhero.builder()
                .idHero(2L)
                .heroName("superman")
                .strength(100)
                .durability(100)
                .build();

        when(repository.findById(eq(1L))).thenReturn(Optional.ofNullable(batman));
        when(repository.findById(eq(2L))).thenReturn(Optional.ofNullable(superman));
        when(random.nextDouble()).thenReturn(0.5);

        FightResponse fightResponse = fightService.startSuperheroesFight(1L , 2L);
        Assertions.assertThat(fightResponse.getWinner().getName()).isEqualTo("superman");
    }
}
