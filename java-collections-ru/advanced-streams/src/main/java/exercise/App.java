package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App{
    public static void main(String[] args) {
        System.out.println(getForwardedVariables("[foo:bar]\n" +
                "environment=\"X_FORWARDED_var1=111\"\n" +
                "\n" +
                "[bar:baz]\n" +
                "environment=\"key2=true,X_FORWARDED_var2=123\"\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "\n" +
                "[baz:foo]\n" +
                "key3=\"value3\"\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "\n" +
                "[program:prepare]\n" +
                "environment=\"key5=value5,X_FORWARDED_var3=value,key6=value6\"\n" +
                "\n" +
                "[program:start]\n" +
                "environment=\"pwd=/temp,user=tirion\"\n" +
                "\n" +
                "[program:options]\n" +
                "environment=\"X_FORWARDED_mail=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'\n" +
                "\n" +
                "[empty]\n" +
                "command=\"X_FORWARDED_HOME=/ cd ~\"\n"));
    }
    public static String getForwardedVariables(String confFile){
            String[] lines = confFile.split("\n");
            return Arrays.stream(lines)
                    .filter(line -> line.startsWith("environment="))
                    .map(line -> line.replaceAll("environment=", ""))
                    .map(line -> line.replaceAll("\"", ""))
                    .map(line -> line.split(","))
                    .flatMap(Arrays::stream)
                    .filter(kv -> kv.startsWith("X_FORWARDED_"))
                    .map(kv -> kv.replaceFirst("X_FORWARDED_", ""))
                    .collect(Collectors.joining(","));
    }
}
//END
