package org.protocol.header;

import org.math.bit.BitMan;

/**
 * 
 * @author sandiwibowo
 *This class will read from IP header. The member of class is important information
 *from header displayed in human readable..
 */
public class ReadIP {
	byte version;
	private byte headerLength;
	byte typeOfService;
	int totalLenth;
	int identification;
	boolean x;
	boolean D;
	boolean M;
	byte[] fragmentOff;
	int timeToLive;
	byte protocol;
	int headerChecksum;
	short[] sourceAddress;
	short[] destinationAddress;
	byte[] ipOption;
	
	byte[] headerByte;
	int posRead;

	/**
	 * Constructor input is byte array
	 * @param headerByte
	 */
	public ReadIP(byte[] headerByte){
		this.headerByte=headerByte;
		posRead=0;
		readVersion();
		readTOS();
		readTotalLength();
		readIdent();
		readFragment();
		readTTL();
		readProtocol();
		readHeaderCheckSum();
		readSourceAddress();
		readDestinationAddress();
	}
	private void readVersion(){
		int verLen=1;
		byte[] btemp=new byte[verLen];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, verLen);
		posRead+=(verLen);
		this.version= (byte) (btemp[0]>>4);
		this.headerLength=((byte) (btemp[0]&23));
	}
	private void readTOS(){
		int tosLen=1;
		byte[] btemp=new byte[tosLen];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, tosLen);
		posRead+=tosLen;
		this.typeOfService=btemp[0];
	}
	private void readTotalLength(){
		int totalLength=2;
		byte[] btemp=new byte[totalLength];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, totalLength);
		posRead+=totalLength;
		this.totalLenth=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readIdent(){
		int identLength=2;
		byte[] btemp=new byte[identLength];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, identLength);
		posRead+=identLength;
		this.identification=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readFragment(){
		int fragLength=2;
		this.fragmentOff=new byte[fragLength];
		System.arraycopy(headerByte, 0+posRead,this.fragmentOff, 0, fragLength);
		posRead+=fragLength;
		//x check
        if (BitMan.getBitByte(fragmentOff[0], (byte)0)!=0){
        	this.x=true;
        }
        else{
        	this.x=false;
        }
        //D check
        if (BitMan.getBitByte(fragmentOff[0], (byte)1)!=0){
        	this.D=true;
        }
        else{
        	this.D=false;
        }
        //M check
        if (BitMan.getBitByte(fragmentOff[0], (byte)2)!=0){
        	this.M=true;
        }
        else{
        	this.M=false;
        }
	}
	
	private void readTTL(){
		int ttlSize=1;
		byte[] btemp=new byte[ttlSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, ttlSize);
		posRead+=ttlSize;
		this.timeToLive=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readProtocol(){
		int protocolSize=1;
		byte[] btemp=new byte[protocolSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, protocolSize);
		posRead+=protocolSize;
		this.protocol=(byte)BitMan.byteArrtoInt(btemp);
	}
	private void readHeaderCheckSum(){
		int headerCheckSumSize=2;
		byte[] btemp=new byte[headerCheckSumSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, headerCheckSumSize);
		posRead+=headerCheckSumSize;
		this.headerChecksum=(int)BitMan.byteArrtoInt(btemp);
	}
	private void readSourceAddress(){
		int sourceAddressSize=4;
		byte[] btemp=new byte[sourceAddressSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, sourceAddressSize);
		posRead+=sourceAddressSize;
		this.sourceAddress=new short[sourceAddressSize];
		short tempNumber=255;
		for (int i=0;i<sourceAddressSize;i++){
			sourceAddress[i]=(short) ((short)btemp[i] & tempNumber);
		}
	}
	private void readDestinationAddress(){
		int destinationAddressSize=4;
		byte[] btemp=new byte[destinationAddressSize];
		System.arraycopy(headerByte, 0+posRead,btemp, 0, destinationAddressSize);
		posRead+=destinationAddressSize;
		this.destinationAddress=new short[destinationAddressSize];
		short tempNumber=255;
		for (int i=0;i<destinationAddressSize;i++){
			destinationAddress[i]=(short) ((short)btemp[i] & tempNumber);
		}
	}
	private void readOption(){
		System.out.println(this.headerByte.length);
		int optionSize=this.headerByte.length-posRead;
		this.ipOption=new byte[optionSize];
		System.arraycopy(headerByte, 0+posRead,this.ipOption, 0, optionSize);
		posRead+=optionSize;
	}
	public byte getVersion() {
		return version;
	}
	public byte getHeaderLength() {
		return headerLength;
	}
    public int getTotalLenth() {
		return totalLenth;
	}
	public int getIdentification() {
		return identification;
	}
	public boolean isX() {
		return x;
	}
	public boolean isD() {
		return D;
	}
	public boolean isM() {
		return M;
	}
	public byte[] getFragmentOff() {
		return fragmentOff;
	}
	public int getTimeToLive() {
		return timeToLive;
	}
	public byte getProtocol() {
		return protocol;
	}
	public int getHeaderChecksum() {
		return headerChecksum;
	}
	public short[] getSourceAddress() {
		return sourceAddress;
	}
	public short[] getDestinationAddress() {
		return destinationAddress;
	}
	
}
