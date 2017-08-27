# DataProcessing
Load big data, cleaning, processing and store them in DB

1. I have finished data cleaning, processing and loading them into DB. But if you need load data again, please set loaddata = yes in application.properties.
and set your data file like this:

dataset.url = /Users/rogersong/Downloads/tier1FBPosts.csv      // means post file

comments.url = /Users/rogersong/Downloads/tier1FBPosts_facebook_comments.csv    // means comments file

2. That's backend project, need running with frontend project.
3. compiling command: mvn clean install -Dmaven.test.skip=true 
4. I have added some unit test in it, so for compiling, please use mvn clean install -Dmaven.test.skip=true to skip unit test.
5. Provide some rest API being called by frontend
6. Used java -jar package name to run it
7. I choose Mysql for basic DB, I created it in my AWS RDS service.
8. For db sql, please check db.sql
9. You can run frontend proj and backend proj in your local machine.
10. backend service running on port 5000, localhost.
11. frotend service running on port 3000, localhost.
12. Used Mybatis for OR mapping.

Next:
1. Add log4j into the proj.
2. Draw frontend and let it more beautiful.
3. Reduce hard code in frontend proj.
4. add more unit test
# dataprocessing-spark-aws
