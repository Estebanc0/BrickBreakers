package com.mygdx.game;

public class PaddleC implements BallColisionS {

	@Override
	public void colision(PingBall a, GameObject b) {
		// TODO Auto-generated method stub
		int yS=a.getySpeed();
		Paddle aux=(Paddle)b;
		
		if (a.collidesWith(aux)) {
            yS = -yS;
            a.setySpeed(yS);
        }
	}

}
