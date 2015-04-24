import java.net.URL;


import org.protocol.header.ReadIP;
import org.protocol.header.ReadTCP;
import org.stream.input.StreamByte;
public class ReadBinary {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		ReadBinary c = new ReadBinary();
	    Class cls = c.getClass();
		URL urlTCP = c.getClass().getResource("/reso/tcphead.bin");
		StreamByte streamTCP=new StreamByte(urlTCP.getPath());
		byte[] tcpbyte=streamTCP.getByteIn();
        ReadTCP tcp=new ReadTCP(tcpbyte);
		System.out.println("source port ="+tcp.getSourcePort());
		System.out.println("destination port="+tcp.getDestinationPort());
		System.out.println("seq number="+tcp.getSequenceNumber());
		System.out.println("ack number"+tcp.getAcknowledmentNumber());
		System.out.println("header length"+tcp.getHeaderLength());
		System.out.println("F="+tcp.isFIN());
		System.out.println("S="+tcp.isSYN());
		System.out.println("R="+tcp.isRST());
		System.out.println("P="+tcp.isPSH());
		System.out.println("A="+tcp.isACK());
		System.out.println("U="+tcp.isURG());
		System.out.println("window size="+tcp.getWindowSize());
		
        
        URL urlIPheader=c.getClass().getResource("/reso/iphead.bin");
        StreamByte streamIPheader=new StreamByte(urlIPheader.getPath());
        byte[] ipHeaderByte=streamIPheader.getByteIn();
        ReadIP ipheader=new ReadIP(ipHeaderByte);
		System.out.println("");
        System.out.println("ip version="+ipheader.getVersion());
        System.out.println("ip header length="+ipheader.getHeaderLength());
        System.out.println("total length="+ipheader.getTotalLenth());
        System.out.println("identification="+ipheader.getIdentification());
        System.out.println("time to live="+ipheader.getTimeToLive());
        System.out.println("protocol="+ipheader.getProtocol());
        System.out.println("checkSum="+ipheader.getHeaderChecksum());
        System.out.print("source Address=");
        for(int i=0;i<4;i++){
        	 System.out.print(ipheader.getSourceAddress()[i]);
        	 System.out.print(".");
        }
        System.out.println("");
        System.out.print("destination Address=");
        for(int i=0;i<4;i++){
        	 System.out.print(ipheader.getDestinationAddress()[i]);
        	 System.out.print(".");
        }
	}
}
