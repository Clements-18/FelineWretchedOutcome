import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;



public class BowlingTest{
  public Bowling fiveSpare; 
  public Bowling invalThrowGame;
 	public Bowling allGutters; 
  public Bowling invalFrameGame;
	public Bowling perfect;
	public Bowling ninetyPoints;  

	@Before
	public void setUp() throws Exception {
		perfect = new Bowling("X-X-X-X-X-X-X-X-X-XXX");
    
		allGutters = new Bowling("00-00-00-00-00-00-00-00-00-00");
		ninetyPoints = new Bowling("45-53-37-27-09-63-71-08-90-72");
		fiveSpare = new Bowling("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/-5");
		invalFrameGame = new Bowling("34-17-8/-X-21-25-61-22-45-23-56-70");
		invalThrowGame = new Bowling("45-18-63-78-182-63-81-18-77-72");
    
	}

	@Test
	public void isPerfect(){
		assertEquals(perfect.score(), 300);
	}

  @Test
	public void is90(){
		assertEquals(ninetyPoints.score(), 90);
	}
	@Test
	public void isGutter(){
		assertEquals(allGutters.score(), 0);
	}
  
	@Test
	public void isinvalFrame(){
		assertEquals(invalFrameGame.score(), 0);
	}
	@Test
	public void is150(){
		assertEquals(fiveSpare.score(), 150);
	}


	@Test
	public void isinvalThrows(){
		assertEquals(invalFrameGame.score(), 0);
	}

}



