

public class DESmode {

		//Initial permutation table.
			//private static final 
			// E bit selection table.
			private static final byte[] EP = {
					32, 1,  2,  3,  4,  5,
					4,  5,  6,  7,  8,  9,
					8,  9,  10, 11, 12, 13,
					12, 13, 14, 15, 16, 17,
					16, 17, 18, 19, 20, 21,
					20, 21, 22, 23, 24, 25,
					24, 25, 26, 27, 28, 29,
					28, 29, 30, 31, 32, 1
			};
			// Final permutation table 
			private static final byte[] FP = {
					40, 8, 48, 16, 56, 24, 64, 32,
					39, 7, 47, 15, 55, 23, 63, 31,
					38, 6, 46, 14, 54, 22, 62, 30,
					37, 5, 45, 13, 53, 21, 61, 29,
					36, 4, 44, 12, 52, 20, 60, 28,
					35, 3, 43, 11, 51, 19, 59, 27,
					34, 2, 42, 10, 50, 18, 58, 26,
					33, 1, 41, 9, 49, 17, 57, 25
			};
			// First Permutation table reduces key from 64 bits to 56 bits.
			private static final byte[] KP1 = {
					57, 49, 41, 33, 25, 17, 9,
					1,  58, 50, 42, 34, 26, 18,
					10, 2,  59, 51, 43, 35, 27,
					19, 11, 3,  60, 52, 44, 36,
					63, 55, 47, 39, 31, 23, 15,
					7,  62, 54, 46, 38, 30, 22,
					14, 6,  61, 53, 45, 37, 29,
					21, 13, 5,  28, 20, 12, 4
			};
			//key left shift 
				private static final byte[] shift_table = {
						1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
				};
				
			// second permutation table reduces key from 56 bits to 48 bits. 
			private static final byte[] PC2 = {
					14, 17, 11, 24, 1,  5,
					3,  28, 15, 6,  21, 10,
					23, 19, 12, 4,  26, 8,
					16, 7,  27, 20, 13, 2,
					41, 52, 31, 37, 47, 55,
					30, 40, 51, 45, 33, 48,
					44, 49, 39, 56, 34, 53,
					46, 42, 50, 36, 29, 32
			};
			

	public static void main(String[] args) {
		byte[] IP = {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,
				62, 54, 46, 38, 30, 22, 14, 6,
				64, 56, 48, 40, 32, 24, 16, 8,
				57, 49, 41, 33, 25, 17, 9,  1,
				59, 51, 43, 35, 27, 19, 11, 3,
				61, 53, 45, 37, 29, 21, 13, 5,
				63, 55, 47, 39, 31, 23, 15, 7
		};
	
	
		System.out.println("The plainText is KARALIEI");
		String plaintext = "KARALIEI";
		plaintext = ConvertTo.toHex(plaintext);
		plaintext = ConvertTo.toBinary(plaintext);
		//Cut white spaces
		plaintext = plaintext.replaceAll("\\s+","");
		System.out.println("Plaintext in binary: "+plaintext);
		int[] M = {0,1,0,0,1,0,1,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,1,1,0,0,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1};
		 
		System.out.println("The key is the  Hex number: 133457799BBCDFF1");
		String key = "133457799BBCDFF1";
		key = ConvertTo.toBinary(key);
		//Cut White Spaces
		key = key.replaceAll("\\s+","");
		System.out.println("Encryption key in binary:" +key);
		int[] K = {0,0,0,1,0,0,1,1,0,0,1,1,0,1,0,0,0,1,0,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1};
		
		//Initial Permutation for Plaintext
		StringBuilder builderIP = new StringBuilder();
		int[] IPtext = new int[M.length];
		int element =0;
		for(int i=0; i<M.length; i++) {
			element = IP[i];
			IPtext[i] = M[element-1];
			builderIP.append(IPtext[i]);
		}
		System.out.println("----------------------------------");
		System.out.println("IPtext: "+builderIP.toString());
		
		//Divide plaintext in two blocks of 32-bits
		int[] L = new int[32];
		int[] R = new int[32];
		
		for(int i=0; i<32; i++ ) 
			L[i] = IPtext[i];
	
		int j=0;
		for(int i=32; i<64; i++) {
			R[j] = IPtext[i];
			j++;
		}
		
	//KEY
		//Permuted Choice 1 for key
		StringBuilder builderPC1 = new StringBuilder();
		int[] PCkey = new int[M.length];
		int keyElement = 0;
		for(int i=0; i<KP1.length; i++) {
			keyElement = KP1[i];
			PCkey[i] = K[keyElement-1];
			builderPC1.append(PCkey[i]);
		}
		System.out.println("K+: " +builderPC1.toString());
		
		//Divide plaintext in two blocks of 32-bits
		int[] Lk = new int[28];
		int[] Rk = new int[28];
		
		for(int i=0; i<28; i++ ) 
			Lk[i] = PCkey[i];
	
		int k=0;
		for(int i=28; i<56; i++) {
			Rk[k] = PCkey[i];
			k++;
		}
		
		int[] leftKey = new int[56];
		int[] endKey = new int[48];
		
		for(int i=0; i<16; i++) {
						
				int[] LCS_Lk = EncryptMethod.leftShift(Lk, shift_table[i]);
				int[] LCS_Rk = EncryptMethod.leftShift(Rk, shift_table[i]);
			
				Lk = LCS_Lk;
				Rk = LCS_Rk;
			
			
			//Permuted Choice -2
			for(int index=0; index<56; index++) {
				
				if(index<28) {
					leftKey[index] = Lk[index];
				}else
					leftKey[index] = Rk[index-28];
				}//end_for
			
			StringBuilder builderKey = new StringBuilder();
			for(int n=0; n<48; n++) {
				endKey[n] = leftKey[PC2[n]-1];
				builderKey.append(endKey[n]);
			}
			System.out.println("Key"+(i+1)+": "+builderKey.toString());
			
			//Expanded Permutation plaintext
			int[] temp = new int[48];
			for(int m=0; m<48; m++) {
				temp[m] = R[EP[m]-1];
			}
			
			//XOR
			int[] sBox = EncryptMethod.XOR(temp, endKey);
			int[] permTable = EncryptMethod.S_box(sBox); 
			permTable = EncryptMethod.XOR(permTable, L);
			//int[] tempTable = L;
			L = R;
			R = permTable;
			StringBuilder builderR = new StringBuilder();
			StringBuilder builderL = new StringBuilder();
			for(int t=0; t<32; t++) {
				builderR.append(R[t]);
				builderL.append(L[t]);
			}
			System.out.println("----------------------------------------------");
			System.out.println("ROUND "+(i+1)+" text blocks");
			System.out.println("R: "+builderR.toString());
			System.out.println("L: "+builderL.toString());
		}
		
		//Swap
		int[] fTable = new int[64];
		for(int b=0; b<64; b++) {
			if(b<32) {
				fTable[b] = R[b];
			}else
				fTable[b] = L[b-32];
			//System.out.println(fTable[b]);
			}//end_for
		
		int[] ciphertext = new int[64];
		StringBuilder builder1 = new StringBuilder();
		for(int d=0; d<64; d++) {
			ciphertext[d] = fTable[FP[d]-1];
			builder1.append(ciphertext[d]);
		}
		String totalCipher = builder1.toString();
		System.out.println("----------------------------------------------");
		System.out.println("CipherText in binary: "+totalCipher);
		System.out.println("CipherText in hex: "+ConvertTo.bintoHex(ciphertext));
		
		
	}	
} // end DES