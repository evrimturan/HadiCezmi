package main.domain.gizmos;

import java.util.ArrayList;
import java.util.List;

import main.domain.Orientation;
import main.domain.Point;
import main.domain.strategy.IMovementStrategy;
import main.physics.Angle;
import main.physics.Circle;
import main.physics.Geometry;
import main.physics.LineSegment;
import main.physics.Vect;
import main.ui.GameWindow;

/**
 *  OVERVIEW: LeftTokat is a special type of the Gizmo object and it is controlled
 *  by the Player 1. Player uses this object to slap the ball.
 *  @since 0.1
 *  @version 0.1
 *  @author JusticeLeague
 */
public class LeftTokat extends Gizmo{

	private Orientation orientation = Orientation.ORIENTATION_ZERO;
	public static int angVel = 0;
	public static int specAngVel = -1;
	private List<Circle> circleList;
	private IMovementStrategy movementStrategy;
	private double length = 1;
	private int lengthPixel;
	private static boolean isMoving;

	/**
	 * Initial constructor of the left tokat object. Length and movement are modified here.
	 * @modifies the movement and the length of this object.
	 */
	public LeftTokat() {
		lengthPixel = (int)(length * GameWindow.getL());
		LeftTokat.isMoving = false;
	}

	/**
	 * sets x coordinate
	 * @modifies x
	 */
	@Override
	public void setX(int x) {
		super.setX(x);
	}
	/**
	 * takes x coordinates
	 * @effects x
	 */
	@Override
	public int getX() {
		return super.getX();
	}

	/**
	 * sets y coordinates and lineSegmentList
	 * @modifies y coordinate, and lineSegmentList, circleList
	 */
	@Override
	public void setY(int y) {
		super.setY(y);
		setOrientation(getOrientation());

		super.setBorderPoints(new ArrayList<Point>());
		super.getBorderPoints().add(new Point(getX(), y));
		super.getBorderPoints().add(new Point(getX()+lengthPixel, y));
		super.getBorderPoints().add(new Point(getX(), y+lengthPixel));
		super.getBorderPoints().add(new Point(getX()+lengthPixel, y+lengthPixel));
		LeftTokat.angVel = 0;
		LeftTokat.specAngVel = -1;
	}
	/**
	 * takes y coordinate of this
	 * @effects y
	 */
	@Override
	public int getY() {
		return super.getY();
	}

	/**
	 * 
	 * @effects the orientation of this object
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * 
	 * @modifies orientation of the object
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
		

		List<LineSegment> segmentList = new ArrayList<LineSegment>();
		circleList = new ArrayList<Circle>();
			
		LineSegment segment1 =new LineSegment(new Vect(getX(), getY()+lengthPixel/4), new Vect(getX()+lengthPixel/2, getY()+lengthPixel/4));
		LineSegment segment2 =new LineSegment(new Vect(getX()+lengthPixel/2, getY()+lengthPixel/4), new Vect(getX()+lengthPixel/2, getY()+lengthPixel*7/4));
		LineSegment segment3 =new LineSegment(new Vect(getX()+lengthPixel/2, getY()+lengthPixel*7/4), new Vect(getX(), getY()+lengthPixel*7/4));
		LineSegment segment4 =new LineSegment(new Vect(getX(), getY()+lengthPixel*7/4), new Vect(getX(), getY()+lengthPixel/4));
		
		Circle circleUp=new Circle(new Vect(getX()+lengthPixel/4, getY()+lengthPixel/4) ,lengthPixel/4);
		Circle circleDown=new Circle(new Vect(getX()+lengthPixel/4, getY()+lengthPixel*7/4) ,lengthPixel/4);

		Vect center = new Vect(getX() + getLengthPixel() , getY() + getLengthPixel() );

		if (orientation == Orientation.ORIENTATION_ZERO) {

		}

		else if (orientation == Orientation.ORIENTATION_90) {

			segment1 = Geometry.rotateAround(segment1, center, Angle.DEG_90);
			segment2 = Geometry.rotateAround(segment2, center, Angle.DEG_90);
			segment3 = Geometry.rotateAround(segment3, center, Angle.DEG_90);
			segment4 = Geometry.rotateAround(segment4, center, Angle.DEG_90);
			
			circleUp =Geometry.rotateAround(circleUp, center, Angle.DEG_90);
			circleDown =Geometry.rotateAround(circleDown, center, Angle.DEG_90);
			
		}

		else if (orientation == Orientation.ORIENTATION_180) {
			
			segment1 = Geometry.rotateAround(segment1, center, Angle.DEG_180);
			segment2 = Geometry.rotateAround(segment2, center, Angle.DEG_180);
			segment3 = Geometry.rotateAround(segment3, center, Angle.DEG_180);
			segment4 = Geometry.rotateAround(segment4, center, Angle.DEG_180);
			
			circleUp =Geometry.rotateAround(circleUp, center, Angle.DEG_180);
			circleDown =Geometry.rotateAround(circleDown, center, Angle.DEG_180);
		}

		else if (orientation == Orientation.ORIENTATION_270) {
			segment1 = Geometry.rotateAround(segment1, center, Angle.DEG_270);
			segment2 = Geometry.rotateAround(segment2, center, Angle.DEG_270);
			segment3 = Geometry.rotateAround(segment3, center, Angle.DEG_270);
			segment4 = Geometry.rotateAround(segment4, center, Angle.DEG_270);
			
			circleUp =Geometry.rotateAround(circleUp, center, Angle.DEG_270);
			circleDown =Geometry.rotateAround(circleDown, center, Angle.DEG_270);
		}

		segmentList.add(segment1);
		segmentList.add(segment2);
		segmentList.add(segment3);
		segmentList.add(segment4);

		circleList.add(circleUp);
		circleList.add(circleDown);
		
		setLineSegmentList(segmentList);
	}
	
	/**
	 * sets the circlelist
	 * @modifies list of the circle list
	 */
	public void setCircleList(List<Circle> list) {
		circleList = list;
	}
	/**
	 * 
	 * @effects the Circle list
	 */
	public List<Circle> getCircleList() {
		return circleList; 
	}
	
	/**
	 * @effects lengthPixel
	 */
	@Override
	public int getLengthPixel() {
		return lengthPixel;
	}

	/**
	 * @modifies lengthPixel
	 */
	@Override
	public void setLengthPixel(int lengthPixel) {
		this.lengthPixel = lengthPixel;
		setY(getY());
	}

	/**
	 * @effects length
	 */
	@Override
	public double getLength() {
		return length;
	}


	/**
	 * @modifies length
	 */
	@Override
	public void setLength(double length) {
		this.length = length;
		setLengthPixel((int)(length*GameWindow.getL()));
	}

	/**
	 * @effects the linesegmentlist of this object
	 */
	@Override
	public List<LineSegment> getLineSegmentList() {
		return super.getLineSegmentList();
	}

	/**
	 * @effects the x coordinates of this object
	 */
	@Override
	public List<Integer> getXCoordinates() {
		return super.getXCoordinates();
	}
	/**
	 * @effects the y coordinates of this object
	 */
	@Override
	public List<Integer> getYCoordiantes() {
		return super.getYCoordiantes();
	}

	/**
	 * 
	 * @modifies linesegments of this object
	 */
	@Override
	public void setLineSegmentList(List<LineSegment> list) {
		super.setLineSegmentList(list);
	}
	/**
	 * 
	 * @modifies the x coordinates of this object
	 */
	@Override
	public void setXCoordinates(List<Integer> list) {
		super.setXCoordinates(list);
	}
	/**
	 * 
	 * @modifies the x coordinates of this object
	 */
	@Override
	public void setYCoordinates(List<Integer> list) {
		super.setYCoordinates(list);
	}

	/**
	 * takes movementStrategy of this
	 * @effects the movementStrategy
	 */
	@Override
	public IMovementStrategy getMovementStrategy() {
		return movementStrategy;
	}

	/**
	 * sets movementStrategy specifying how to move for this
	 * @modifies movementStrategy
	 */
	@Override
	public void setMovementStrategy(IMovementStrategy movementStrategy) {
		this.movementStrategy = movementStrategy;
	}

	/**
	 * @effects the angular velocity of this object
	 */
	public static int getAngVel() {
		// TODO Auto-generated method stub
		return angVel;
	}

	/**
	 * @modifies the angular velocity of this object
	 */
	public static void setAngVel(int i) {
		// TODO Auto-generated method stub
		angVel = i;
	}

	/**
	 * @effects the movement of this object
	 */
	public static boolean isIsMoving() {
		return isMoving;
	}

	/**
	 * @modifies the movement of this object
	 */
	public static void setIsMoving(boolean isMoving) {
		LeftTokat.isMoving = isMoving;
	}
	
	/**
	 * 
	 * @modifies the x coordinates of this object only in an array(for painting polygon)
	 */
	@Override
	public void setXArray(int[] array) {
		super.setXArray(array);
	}
	/**
	 * @effects the x coordinates of this object only in an array(for painting polygon)
	 */
	@Override
	public int[] getXArray() {
		return super.getXArray();
	}
	/**
	 * 
	 * @modifies the y coordinates of this object only in an array(for painting polygon)
	 */
	@Override
	public void setYArray(int[] array) {
		super.setYArray(array);
	}
	/**
	 * @effects the y coordinates of this object only in an array(for painting polygon)
	 */
	@Override
	public int[] getYArray() {
		return super.getYArray();
	}
}
