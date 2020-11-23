import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class FarmerFactoryTest {

    GameState easyGameState;
    Farmer farmer;
    @Mock
    Random random;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {

    }

    /**
     * Uses the FarmerFactory to return a farmer with a profit affinity.
     */
    @Test
    public void createFarmerShouldReturnProfitAffinityDecoratedFarmer() {
        FarmerFactory farmerFactory = new FarmerFactory();
        when(random.nextDouble()).thenReturn(1.0);
        GameStateFactory gameStateFactory = new GameStateFactory(random);
        easyGameState = gameStateFactory.getGameState("Easy");
        when(random.nextDouble()).thenReturn(1.0).thenReturn(1.0);
        easyGameState.setFarmer(farmerFactory.createFarmer("easy", random));
        assertEquals(easyGameState.getFarmer().getProfitAffinity(), 15.75, 0.005);
    }

    /**
     * Uses the FarmerFactory to return a farmer with a crop affinity.
     */
    @Test
    public void createFarmerShouldReturnCropAffinityDecoratedFarmer() {
        FarmerFactory farmerFactory = new FarmerFactory();
        when(random.nextDouble()).thenReturn(1.0);
        GameStateFactory gameStateFactory = new GameStateFactory(random);
        easyGameState = gameStateFactory.getGameState("Easy");
        when(random.nextDouble()).thenReturn(1.0).thenReturn(0.0).thenReturn(1.0);
        easyGameState.setFarmer(farmerFactory.createFarmer("easy", random));
        assertEquals(easyGameState.getFarmer().getCropAffinity(), 15.75, 0.005);
    }

    /**
     * Uses the FarmerFactory to return a farmer with a husbandry affinity.
     */
    @Test
    public void createFarmerShouldReturnHusbandryAffinityDecoratedFarmer() {
        FarmerFactory farmerFactory = new FarmerFactory();
        when(random.nextDouble()).thenReturn(1.0);
        GameStateFactory gameStateFactory = new GameStateFactory(random);
        easyGameState = gameStateFactory.getGameState("Easy");
        when(random.nextDouble()).thenReturn(1.0).thenReturn(0.0).thenReturn(0.0).thenReturn(0.3);
        easyGameState.setFarmer(farmerFactory.createFarmer("easy", random));
        assertEquals(easyGameState.getFarmer().getHusbandryAffinity(), 11.25, 0.005);
    }

    /**
     * Uses the FarmerFactory to return a farmer with base affinity.
     */
    @Test
    public void createFarmerShouldReturnBaseAffinityDecoratedFarmer() {
        FarmerFactory farmerFactory = new FarmerFactory();
        when(random.nextDouble()).thenReturn(1.0);
        GameStateFactory gameStateFactory = new GameStateFactory(random);
        easyGameState = gameStateFactory.getGameState("Easy");
        when(random.nextDouble()).thenReturn(1.0).thenReturn(0.0).thenReturn(0.0).thenReturn(1.0);
        easyGameState.setFarmer(farmerFactory.createFarmer("easy", random));
        assertEquals(easyGameState.getFarmer().getProfitAffinity(), 3.5, 0.005);
    }
}
