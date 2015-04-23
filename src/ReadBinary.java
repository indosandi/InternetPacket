import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.math.bit.BitMan;
import org.protocol.header.ReadTCP;
import org.stream.input.StreamByte;
public class ReadBinary {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
//		File resourceDir = getDirectory("res");
		ReadBinary c = new ReadBinary();
	    Class cls = c.getClass();
		URL url1 = c.getClass().getResource("/reso/test.bin");
//		System.out.println(url1.getPath());
		StreamByte s=new StreamByte(url1.getPath());
		byte[] test=s.getByteIn();
		for(int i=7;i>=0;i--){
			System.out.print(BitMan.getBit(test[13],(byte)i));

		}
//        ByteBuffer bb=ByteBuffer.allocate(4);
//		byte b1=2;
//		byte b2=1;
//		byte b3=0;
//		byte[] barr=new byte[2];
//		barr[0]=test[2];
//		barr[1]=test[3];
//		System.out.println(BitMan.byteArrtoInt(barr));
//		byte b4=test[2];
//		System.out.println(b4);
//		bb.order(ByteOrder.BIG_ENDIAN);
//		bb.put(b1);
//		bb.put(b2);
//		bb.put(b3);
//		bb.put(b4);
//		System.out.println(bb.getShort(0));
//		System.out.println(bb.getShort(2));
		ReadTCP tcp1=new ReadTCP(test);
		System.out.println(tcp1.getSourcePort());
		System.out.println(tcp1.getDestinationPort());
		System.out.println(tcp1.getSequenceNumber());
		System.out.println(tcp1.getAcknowledmentNumber());
		System.out.println(tcp1.getHeaderLength());
		System.out.println(tcp1.isFIN());
		System.out.println(tcp1.isSYN());
		System.out.println(tcp1.isRST());
		System.out.println(tcp1.isPSH());
		System.out.println(tcp1.isACK());
		System.out.println(tcp1.isURG());
		System.out.println(tcp1.getWindowSize());
		byte[] check=tcp1.getOption();
		
        for(int j=0;j<check.length;j++){
			for(int i=7;i>=0;i--){
                System.out.print(BitMan.getBit(check[j],(byte)i));
			}
			System.out.println("");
		}
        
	}
	
}
