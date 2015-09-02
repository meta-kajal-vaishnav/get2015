package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MirrorTreeTest 
{

	@Test
	public void testIfMirror()
	{
		MirrorTree objMirrorTree1 = new MirrorTree();
		objMirrorTree1.insertInTree1 ( 4 );
		objMirrorTree1.insertInTree1 ( 3 );
		objMirrorTree1.insertInTree1 ( 5 );
		
		MirrorTree objMirrorTree2 = new MirrorTree();
		objMirrorTree2.insertInTree2 ( 4 );
		objMirrorTree2.insertInTree2 ( 3 );
		objMirrorTree2.insertInTree2 ( 5 );
		
		int result = objMirrorTree1.compareIfMirror ( objMirrorTree2 );
		int expected = 1;
		
		assertEquals ("Matched", expected, result);
		
	}

}
