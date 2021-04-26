
javac -sourcepath src src\com\jdh\microcraft\Main.java -d out\production\Microcraft
mkdir out\artifacts\Microcraft\res
xcopy /s /e res out\production\Microcraft\res
jar -cmvf src\META-INF\MANIFEST.MF out\artifacts\Microcraft\Microcraft.jar -C out\production\Microcraft\ .
Launch4J\launch4jc.exe Launch4JConfig.xml