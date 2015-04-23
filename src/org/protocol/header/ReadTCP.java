package org.protocol.header;
import org.math.bit.BitMan;

public class ReadTCP {
	int sourcePort;
	int destinationPort;
	int sequenceNumber;
	int acknowledmentNumber;
	int headerLength;
	boolean URG;
	boolean ACK;
	boolean PSH;
	boolean RST;
	boolean SYN;
	boolean FIN;
	int windowSize;
	byte[] checkSum;
	byte[] urgent;
	byte[] option;
	
	byte[] headerByte;
	int byteSize;
	int posRead;
	
	public ReadTCP(byte[] headerByte){
		this.headerByte=headerByte;
		posRead=0;
		readPort();
		readSEQACK();
		readHeadLen();
		readFlag();
		readWindow();
		readCheckSum();
		readUrgPointer();
		readOption();
	}
	private void readPort(){
		int portSourceSize=2;
		int portDestSize=2;
		byte[] btemp=new byte[portSourceSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, portSourceSize);
        posRead+=(portSourceSize);
        this.sourcePort=(int)BitMan.byteArrtoInt(btemp);
		System.arraycopy(headerByte, 0+posRead,btemp, 0, portDestSize);
        posRead+=(portDestSize);
        this.destinationPort=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readSEQACK(){
		int seqSize=4;
		int ackSize=4;
		byte[] btemp=new byte[seqSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, seqSize);
		posRead+=seqSize;
		this.sequenceNumber=(int)BitMan.byteArrtoInt(btemp);
		System.arraycopy(headerByte, 0+posRead,btemp, 0, ackSize);
		posRead+=ackSize;
		this.acknowledmentNumber=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readHeadLen(){
		int hLen=1;
		byte[] btemp=new byte[hLen];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, hLen);
		posRead+=(hLen);
		this.headerLength=(int)BitMan.byteArrtoInt(btemp)/4;
	}
	private void readFlag(){
		int refflag=1;
		byte[] btemp=new byte[refflag];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, refflag);
		posRead+=refflag;
		//FIN check
		if (BitMan.getBitByte(btemp[0], (byte)0)!=0){
			this.FIN=true;
		}
		else{
			this.FIN=false;
		}
		//SYN check
		if (BitMan.getBitByte(btemp[0], (byte)1)!=0){
			this.SYN=true;
		}
		else{
			this.SYN=false;
		}
		//RST check
		if (BitMan.getBitByte(btemp[0], (byte)2)!=0){
			this.RST=true;
		}
		else{
			this.RST=false;
		}
        //PSH check
		if (BitMan.getBitByte(btemp[0], (byte)3)!=0){
			this.PSH=true;
		}
		else{
			this.PSH=false;
		}
        //ACK check
		if (BitMan.getBitByte(btemp[0], (byte)4)!=0){
			this.ACK=true;
		}
		else{
			this.ACK=false;
		}
        //URG check
		if (BitMan.getBitByte(btemp[0], (byte)5)!=0){
			this.URG=true;
		}
		else{
			this.URG=false;
		}
	}
	private void readWindow(){
		int windowSize=2;
		byte[] btemp=new byte[windowSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, windowSize);
        posRead+=(windowSize);
        this.windowSize=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readCheckSum(){
		int checkSumSize=2;
		this.checkSum=new byte[checkSumSize];
		System.arraycopy(headerByte, 0+posRead,checkSum, 0, checkSumSize);
		posRead+=checkSumSize;
	}
	private void readUrgPointer(){
		int urgentPointerSize=2;
		this.urgent=new byte[urgentPointerSize];
		System.arraycopy(headerByte, 0+posRead,this.urgent, 0, urgentPointerSize);
		posRead+=urgentPointerSize;
	}
	private void readOption(){
		System.out.println(this.headerByte.length);
		System.out.println("ok");
		System.out.println(posRead);
		int optionSize=this.headerByte.length-posRead;
		this.option=new byte[optionSize];
		System.arraycopy(headerByte, 0+posRead,this.option, 0, optionSize);
		posRead+=optionSize;
	}
	// ---------------all get --------------
	public int getSourcePort() {
		return sourcePort;
	}
	public int getDestinationPort() {
		return destinationPort;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public int getAcknowledmentNumber() {
		return acknowledmentNumber;
	}
	public int getHeaderLength() {
		return headerLength;
	}
	public boolean isURG() {
		return URG;
	}
	public boolean isACK() {
		return ACK;
	}
	public boolean isPSH() {
		return PSH;
	}
	public boolean isRST() {
		return RST;
	}
	public boolean isSYN() {
		return SYN;
	}
	public boolean isFIN() {
		return FIN;
	}
	public int getWindowSize() {
		return windowSize;
	}
	public byte[] getCheckSum() {
		return checkSum;
	}
	public byte[] getUrgent() {
		return urgent;
	}
	public byte[] getOption() {
		return option;
	}
	
	// finished all get----------------
}
