
# ucsb-cs56-goodsleepalarm
gives users sleep suggestions based on schedule...

=======

https://cs56-goodsleepalarm.herokuapp.com/

Setting up Google Credentials

Using Google Credentials
1. To use your Google credentials for localhost / heroku, copy localhost / heroku.json.SAMPLE to localhost / heroku.json at the project root
2. Modify localhost / heroku.json by putting in your client id and client secret where indicated
3. For heroku, run `./setHerokuEnv.py --app cs56-goodsleepalarm` ; For localhost run . env.sh from the root
4. Finally deploy / run the webapp with `mvn spring-boot:run` or `mvn package heroku:deploy`
