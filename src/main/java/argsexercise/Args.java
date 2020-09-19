package argsexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Args {
    private String argsText;

    public Args(String argsText) {
        this.argsText = argsText;
    }

    public List<Arg> scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        keyValues = keyValues.stream()
//                .map(String::trim)
                .map(keyValue -> keyValue.trim())
                .collect(Collectors.toList());
        keyValues = keyValues.subList(1, keyValues.size());

        return getKeyValuePairs(keyValues);
    }

    private List<Arg> getKeyValuePairs(List<String> keyValues) {
        List<Arg> args = new ArrayList<>();
        keyValues.forEach(keyValue -> {
            String [] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            args.add(new Arg(key, value));
        });
        return args;
    }

    public List<String> scan2() {
        List<String> keyValues = Arrays.asList(" ".concat(argsText).split("-"));
        return keyValues.subList(1, keyValues.size());
    }
}
