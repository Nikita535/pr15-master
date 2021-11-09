package com.company;
import java.util.HashMap;
import java.util.Map;

public class ExampleMap {

    public static HashMap<String,String> createMap(){
        HashMap<String,String> map=new HashMap<String,String >();
        map.put("Жизневский","Никита");
        map.put("Ермаков","Егор");
        map.put("Романес","Александр");
        map.put("Шичин","Роман");
        map.put("Савельев","Антон");
        map.put("Наумов","Сергей");
        map.put("Иванов","Петр");
        map.put("Козлов","Антон");
        map.put("Гитлер","Адольф");
        map.put("Сталин","Иосиф");
        return map;
    }

    public static int getSameFirstNameCount(HashMap<String,String> map,String name){
        int count=0;

        //все пары хранятся в интерфейсе Map.Entry. Чтобы их получить map.entryset()
        for(Map.Entry<String,String> p: map.entrySet()){
            if(name.equals(p.getValue())){
                count++;
            }
        }
        return count;
    }

    public static int getSameLastNameCount (HashMap<String,String> map,String lastname){
    int count=0;

    //все пары хранятся в интерфейсе Map.Entry. Чтобы их получить map.entryset()
        for(Map.Entry<String,String> p: map.entrySet()){
        if(lastname.equals(p.getKey())){
            count++;
        }
    }
        return count;
    }


}
