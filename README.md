# StocksMonitor
Web application that helps investors all over the world with accounting and observation of their investment portfolio.

For now it's just keeps list of stock purchases for one test user.

INSTRUCTIONS:
1. Add oracle jdbc driver to lib/ in your tomcat, if you using it
2. Set up your Oracle database, add connection url and credentials into persistence.xml
3. Build mvn clean compile package
4. Deploy StocksMonitor.war
5. Run your server
6. Open %AppServerUrl%/StocksMonitor and try it!