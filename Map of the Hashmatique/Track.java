import java.util.HashMap;
import java.util.Set;
public class Track {
    public static void main(String[] args) {
        HashMap<String, String> Track = new HashMap<String, String>();
        Track.put("Hi", "Hi Hi Hi Hi");
        Track.put("red tomatoe" , "I am a red tomatoe :)))");
        Track.put("Reemy", "blooming heart");
        Track.put("Bye", "bye bye");
        String name = Track.get("Reemy");
        System.out.println(name);
        Set<String> keys = Track.keySet();
            for(String key : keys) {
                System.out.println(key+':'+Track.get(key));
}
    }
}
