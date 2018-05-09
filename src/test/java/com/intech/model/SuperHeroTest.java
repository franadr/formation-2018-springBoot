package com.intech.model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SuperHeroTest {

    private Superhero superhero;

    @Before
    public void setUp() throws Exception {

        superhero = new Superhero();
    }

    @Test
    public void GetDamage_test(){

        int val = 20;
        superhero.setCombat(val);
        superhero.setIntelligence(val);
        superhero.setStrength(val);
        superhero.setSpeed(val);
        double expectedDamages = 2.0;
        Assertions.assertThat (superhero.getBaseDamages() ).isEqualTo(expectedDamages);
    }
}
