<html>
   <body style="font-family: verdana;" bgcolor="#A9A9A9">
      <h2 align="center">
      <img border="0"  height="6%" align="left" hspace="2" vspace="0" src="file:///${logoImagePath}" ></img>
       AUTOMATION TEST REPORT
      
      </h2>
      
 <table border="1" width ="100%"> 
      	<tr>
      		<td><h4 style="color:#2554C7">SUMMARY</h4>
      
      
      			<table border="1">
							<tr>
								<td>
									<b>Build</b>
								</td>
								<td>NA</td>
							</tr>
							<tr>
								<td><b>Browser</b></td>
								<td>${BrowserType}</td>
							</tr>
							
						</table>
						
						
						<br><br>
						
						<table border="1" >
						<tr bgcolor="#1589FF">
							<th>Description</th>
							<th>Status</th>
						</tr>
						<xsl:for-each select="Result">
						<tr>
							<td>Test Cases Executed</td>
							<td align="center">${MasterTotal}</td>
						</tr>
						<tr>
							<td>Test Cases Passed</td>
							<td align="center">${MasterPassed}</td>
						</tr>
						<tr>
							<td>Test Cases Failed</td>
							<td align="center">${MasterFailed}</td>
						</tr>
						<tr>
							<td>Test Cases NotRun</td>
							<td align="center">${MasterSkipped}</td>
						</tr>		
						<tr>
							<td>Total Time</td>
							<td align="center">${MasterSuiteTime}</td>
						</tr>	   
						</xsl:for-each>
					</table>
     
     <#list TestSummaryList as Tslist> 
     
       
      <h4 style="color:#2554C7"> ${Tslist['SuiteName']} summary</h4>
      <table border="1" >
         <tr bgcolor="#1589FF">
            <th>Description</th>
            <th>Status</th>
         </tr>
         
            <tr>
               <td>Test Cases Executed</td>
               <td align="center">
               <#list Tslist?keys as key>
			      <#if key='TotalCount'>
			      ${Tslist[key]}
			      </#if>
			      </#list>
			      
                 
               </td>
            </tr>
            <tr>
               <td>Test Cases Passed</td>
               <td align="center">
               <#list Tslist?keys as key>
			      <#if key='PassedCount'>
			      ${Tslist[key]}
			      </#if>
			     </#list>
			     
			     </td>
            </tr>
            <tr>
               <td>Test Cases Failed</td>
               <td align="center">
               <#list Tslist?keys as key>
			      <#if key='FailedCount'>
			      ${Tslist[key]}
			      </#if>
			     </#list>
			     
			     </td>
            </tr>
            <tr>
               <td>Test Cases NotRun</td>
                <td align="center">
               <#list Tslist?keys as key>
			      <#if key='SkippedCount'>
			      ${Tslist[key]}
			      </#if>
			     </#list>
			     
			     </td>
            </tr>
            <tr>
               <td>Total Time</td>
               <td align="center">
                   ${Tslist['SuiteTime']}
               </td>
            </tr>
         
      </table>
      <h4 style="color:#2554C7">Test Execution</h4>
      <table border="1" width ="80%" align="center">
         <tr bgcolor="#9acd32">
            <th align="middle">Test Case ID</th>
            <th align="middle">Description</th>
            <th align="middle">Status</th>
            <th align="middle">Time</th>
            <th align="middle">ScreenShot</th>
            <th align="middle">TestCaseLog</th>
         </tr>
         
      <#list TestSuites[Tslist_index] as TC>
      
         <tr>
            
            <#list TC?keys as key>
            <#if key=='TestCaseId'>
            <td width="15%" align="middle">${TC[key]}</td>
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Description'>
            <td width="45%" align="middle">${TC[key]}</td>
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Status' && TC[key]=='PASSED'>
            
            <td width="20%" align="middle"><table><tr align="middle"><td width="50%">${TC[key]}</td>
            <td><img border="0"  align="middle" hspace="2" vspace="2" src="file:///${PassedImage}"></img></td></tr></table></td>
            
            
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Status' && TC[key]=='FAILED'>
            
            
            <td width="20%" align="middle"><table><tr align="middle"><td width="50%">${TC[key]}</td>
            <td><img border="0"  align="middle" hspace="2" vspace="2" src="file:///${FailedImage}" title="${TC['ErrorStackTrace']?html}"></img></td></tr></table></td>
            
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Status' && TC[key]=='SKIPPED'>
            
           
            <td width="20%" align="middle"><table><tr align="middle"><td width="50%">${TC[key]}</td>
            <td><img border="0"  align="middle" hspace="2" vspace="2" src="file:///${SkippedImage}"></img></td></tr></table></td>
           
            
            
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Time'>
            <td width="15%" align="middle">${TC[key]}</td>
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='ScreenShotPath'>
            <td width="15%" align="middle"><a href="file:///${TC[key]}"><IMG HEIGHT=50 WIDTH=50 SRC="file:///${TC[key]}"></a></td>
            </#if>
            </#list> 
            
            <#list TC?keys as key>
            <#if key=='TestLog'>
            <td width="15%" align="middle"><a href="file:///${TC[key]}">TestLog</a></td>
            </#if>
            </#list> 
         
         
         </tr>
         </#list>
      </table>
       </#list>
      
      
      
      
      				 </td></tr></table>
      				 
      		<h2 align="center" >FAILED TEST CASES WILL BE REEXECUTED BY THE QA TEAM</h2>
      				 
   </body>
   
   
</html>
