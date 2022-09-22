import java.util.*; 
class mycode
{

public static void main(String[] args) {

Scanner sc = new Scanner (System.in);

String str = sc.nextLine();

ArrayList<Character> vow= new ArrayList<>(), con = new ArrayList<>();


for(char c: str. toCharArray())

if(vowel (c)) vow.add(c);

else con.add(c);

String vout = "",cout="";

Collections. sort (vow);

Collections.sort(con);

for(char c : vow) vout += c;

for(char c : con) cout += c;


if(vow.size() == 0) vout +="NA-1"; else vout += str.indexOf(vout.charAt(0));


if (con.size() == 0) cout += "NA-1"; else cout += str.lastIndexOf(cout.charAt(cout.length()-1)); System.out.println(vout+cout);

}

static boolean vowel (char c) {

String s="aeiou";

return s. indexOf(c) != -1;

}
}