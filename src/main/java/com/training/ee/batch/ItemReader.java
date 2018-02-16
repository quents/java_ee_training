package com.training.ee.batch;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Named("myReader")
public class ItemReader extends AbstractItemReader {

    private List<String> employeeList = new ArrayList<String>();
    private int counter = 0;

    public ItemReader() {
        try(Stream<String> stream = Files.lines(Paths.get("/Users/yusufyazici/Documents/temp1/mylist.txt"))){
            stream.forEach(str -> {
                employeeList.add(str);
            });

        }catch (Exception e){
        }
    }

    @Override
    public Object readItem() throws Exception {
        String employee = null;
        if (counter < employeeList.size()){
            employee = employeeList.get(counter++);
        }
        return employee;
    }
}
