
# ucsb-cs56-goodsleepalarm
gives users sleep suggestions based on schedule...

=======

https://cs56-goodsleepalarm.herokuapp.com/

Setting up Google Credentials

Open the Google API Console Credentials page : https://console.developers.google.com/apis/dashboard
From the project drop-down, choose Create a new project, enter a name for the project, and optionally, edit the provided project ID. Click Create.
On the Credentials page, select Create credentials, then select OAuth client ID.
You may be prompted to set a product name on the Consent screen; if so, click Configure consent screen, supply the requested information, and click Save to return to the Credentials screen.
Select Web application for the Application type, and enter any additional information required.
Click Create.
On the page that appears, copy the client ID and client secret to your clipboard, as you will need them when you configure your client library.

Using Google Credentials
1. To use your Google credentials for localhost / heroku, copy localhost / heroku.json.SAMPLE to localhost / heroku.json at the project root
2. Modify localhost / heroku.json by putting in your client id and client secret where indicated
3. For heroku, run `./setHerokuEnv.py --app cs56-goodsleepalarm` ; For localhost run . env.sh from the root
4. Finally deploy / run the webapp with `mvn spring-boot:run` or `mvn package heroku:deploy`
