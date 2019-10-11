package Subject_demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] temp;

        while ((str = br.readLine()) != null) {

            int naozhongshu=Integer.valueOf(str.trim());

            int[] time =new int[naozhongshu];

            for (int i=0;i<naozhongshu;i++){
                str = br.readLine();
                temp = str.trim().split(" ");
                time[i]=Integer.valueOf(temp[0])*60+Integer.valueOf(temp[1]);
            }
            str = br.readLine();
            int leastTime =Integer.valueOf(str.trim());

            str = br.readLine();
            temp = str.trim().split(" ");
            int startTime =Integer.valueOf(temp[0])*60+Integer.valueOf(temp[1]);

            Solution( time,leastTime ,startTime);
        }
    }

    private static void Solution(int[] time,int leastTime , int startTime) {
        Arrays.sort(time);

        int res =startTime-leastTime;

        for (int i=time.length-1;i>=0;i--){
            if (res>=time[i]){
                System.out.println(time[i]/60+" "+time[i]%60);
                return;
            }
        }

    }

}
