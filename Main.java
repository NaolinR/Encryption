class Main {
  public static void main(String[] args) {
    //convert character o to a letter p
    /*char ch ='o';
    int ascii = (int)ch;
    ch = (char)(ascii+1); 
    System.out.println(ch);
    */

    // We read a file using the Input.readFile
    String line =Input.readFile("quote.txt");

    
    String encodeLine = encode(line);
    Input.writeFile("encodedline.txt",encodeLine);
    System.out.println(encodeLine);
    

    
    String decodeLine = decode(encodeLine);
    System.out.println(decodeLine);
    Input.writeFile("decodedline.txt",decodeLine);
    
  }
    
    // encode a quote by applying a cipher to shift 3 to the right
  public static String encode(String s){
    String level1 = CipherThree(s);
    String level2 = LessThan(level1);
    String level3 = ReverseIt(level2);
    String level4 = Unicode(level3);
    //String level5 = Unicode2(level4);
    //String level6 = level5+level4;
    System.out.println(level1 + " Encrypt Cipher each character");
    System.out.println(level2 + " Encrypt LessThan for every hashtag");
    System.out.println(level3 + " Encrypt ReverseIt, Reversing the entire String");
    System.out.println(level4 + " Encrypt Unicode on each character, Last Encryption Level");
    //System.out.println(level5);
    //System.out.println(level6);
    //System.out.println(level5);
    return level4;
    }

    
  

  // decode a quote applied a cipher by  
  public static String decode(String s){
      String level4 = decryptUnicode(s);
      String level3 = decryptReverseIt(level4);
      String level2 = decryptLessThan(level3);
      String level1 = decryptCipherThree(level2);
      //String level1 = decryptUnicode2(level2);
      System.out.println(level4 + " Decrypts Unicode");
      System.out.println(level3 + " Decrypts ReverseIt");
      System.out.println(level2 + " Decrypts LessThan");
      System.out.println(level1 + " Last Decryption Level");
      //System.out.println(level1);
      return level1;
     
    }
  

    //return encodedLine;
  // encode a quote by applying a cipher to shift 3 to the right
  public static String CipherThree(String s){
    String encodedLine = "";

    for(int idx=0; idx+1 <= s.length(); idx++){
      char ch2 = s.charAt(idx);
      int ascii = (int)ch2;
      ascii+=3;
      ch2 = (char)ascii;
      encodedLine+= ch2;
      //return encodedLine;
    }
    return encodedLine;
  }

  //IF the ascii value is equal to 35 ('#') then convert to ('<')
  public static String LessThan(String s){
    String encodedLine2 = "";
    for(int idx=0; idx+1 <= s.length(); idx++){
      char ch3 = s.charAt(idx);
      //ch3 ='<';
      
      int ascii2 = (int)(ch3);
      //int ascii3 = (ascii2=='<');
      if(ascii2==35){
        //ascii2+=
        //ascii3 = (ascii2==60);
        ch3 = (char)(ascii2+25); 
       

        encodedLine2+=ch3;
      
      }else{
        encodedLine2+=ch3;
      }
      
      
    }
    return encodedLine2;
  }
  
  public static String ReverseIt(String s){
    String encodedLine3 = "";
    
    for(int idx=s.length()-1; idx >= 0; idx--){
      char ch4 = s.charAt(idx);
      //ch3 ='<';
      
      

      encodedLine3+=ch4;
      
      //}else{
        //encodedLine2+=ch3;
      //}
      
      //return encodedLine;
    }
    return encodedLine3;
  }
  
  public static String Unicode(String s){
    String encodedLine4 = "";
    //int base = 1033;

    //int ascii5 = (int)ch5;
    //char ch4[] = s.toCharArray();
    //int base = 0620;
    //for(int idx=base; idx <= base+28; idx++){
    for(int idx=0; idx+1 <= s.length(); idx++){
      char ch5 = s.charAt(idx);
      //ch3 ='<';
      if(idx >= 0 && idx <= s.length()){
        int base = 1310;
        int ascii5 = (int)ch5;
        base += ascii5;
        ch5 = (char)base;
        encodedLine4+=ch5;
      }else{
        encodedLine4+=ch5;
      }
      
      

    }
    return encodedLine4;
  }
  
  
      
  //---------------------------
  // decode a quote that has CipherThree applied
  
  public static String decryptCipherThree(String s){
    String encodedLine = "";

    for(int idx=0; idx+1 <= s.length(); idx++){
      char ch2 = s.charAt(idx);
      int ascii = (int)ch2;
      ascii-=3;
      ch2 = (char)ascii;
      encodedLine+= ch2;
      //return encodedLine;
    }
    return encodedLine;
  }

  public static String decryptLessThan(String s){
    String encodedLine2 = "";

    for(int idx=0; idx+1 <= s.length(); idx++){
      char ch3 = s.charAt(idx);
      int ascii2 = (int)(ch3);
      //int ascii3 = (ascii2=='<');
      if(ascii2==60){
        
        ch3 = (char)(ascii2-25);

        encodedLine2+=ch3;
      
      }else{
        encodedLine2+=ch3;
      }
      
      
    }
    return encodedLine2;
  }

  public static String decryptReverseIt(String s){
    String encodedLine3 = "";
    for(int idx=s.length()-1; idx >= 0; idx--){
      char ch4 = s.charAt(idx);
      encodedLine3 += ch4;
    }
    return encodedLine3;
  }

  public static String decryptUnicode(String s){
    String encodedLine4 = "";
    for(int idx = 0; idx+1 <= s.length(); idx++){
      char ch6 = s.charAt(idx);
      if(idx >= 0 && idx <= s.length()){
        int ascii6 = (int)ch6;
        int originascii = ascii6 - 1310;
        ch6 = (char)originascii;
        encodedLine4 += ch6;
      }else{
        encodedLine4 += ch6;
      }
    }
    return encodedLine4;
  }
  
  

  
}
