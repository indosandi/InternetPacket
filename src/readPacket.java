

import java.nio.ByteBuffer;

public class readPacket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a=0;
		byte a2=0;
		byte a3=0;
		byte a4=2;
		ByteBuffer bb=ByteBuffer.allocate(4);
		bb.put(a);
		bb.put(a2);
		bb.put(a3);
		bb.put(a4);
//		int i=bb.getInt();
		System.out.println(bb.getInt(0));
	}

}
