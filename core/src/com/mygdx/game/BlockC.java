package com.mygdx.game;

public class BlockC implements BallColisionS{
	
	@Override
	public void colision(PingBall a, GameObject b) {
		int yS=a.getySpeed();
		Block aux=(Block)b;
		
		if (a.collidesWith(aux)) {
            yS = -yS;
            a.setySpeed(yS);
            ((Block) b).setDestroyed(true);
        }
	}

}
