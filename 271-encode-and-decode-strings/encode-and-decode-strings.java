public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedStr=new StringBuilder();
        for(String str:strs)
        {
            encodedStr.append(str.length()).append("#").append(str);
        }

        return encodedStr.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStr=new ArrayList<>();
        int i=0;
        while(i<s.length())
        {
            int j=i;
            while(s.charAt(j)!='#')
            {
                j++;
            }
            int length=Integer.parseInt(s.substring(i,j));
            String str=s.substring(j+1,j+1+length);
            decodedStr.add(str);
            i=j+1+length;
        }
        return decodedStr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));