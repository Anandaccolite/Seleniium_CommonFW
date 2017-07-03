<html>
   <body style="font-family: verdana;" bgcolor="#A9A9A9">
      <h2 align="center">
      <img border="0"  height="6%" align="left" hspace="2" vspace="0" src="${logoImagePath}" ></img>
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
								<td>CS BUILD #118</td>
							</tr>
							<tr>
								<td><b>Browser</b></td>
								<td>FIREFOX</td>
							</tr>
							
</table>
      <h4 style="color:#2554C7">Test Suite summary</h4>
      
      <table border="1" >
         <tr bgcolor="#1589FF">
            <th>Description</th>
            <th>Status</th>
         </tr>
         
            <tr>
               <td>Test Cases Executed</td>
               
               <td align="center">
                  ${SummaryTotal}
               </td>
               	
      
            </tr>
            <tr>
               <td>Test Cases Passed</td>
               	
               <td align="center">
                  ${SummaryPassed}
               </td>
               
            </tr>
            <tr>
               <td>Test Cases Failed</td>
              	
               <td align="center">
                  ${SummaryFailed}
               </td>
               
            </tr>
            <tr>
               <td>Test Cases NotRun</td>
              
               <td align="center">
                  ${SummarySkipped}
               </td>
               	
            </tr>
            <tr>
               <td>Total Time</td>
               <td align="center">
                  
               </td>
            </tr>
         
      </table>
     <#list TestSuites as TestSuite>
     
     
       
      
      
      <#list TC?keys as key>
      <#if key='SuiteName'>
      <h4 style="color:#2554C7">${TC[key]} Execution</h4>
      </#if>
      </#list>
      </#list>
      
       <table border="1" >
         <tr bgcolor="#1589FF">
            <th>Description</th>
            <th>Status</th>
         </tr>
         
            <tr>
               <td>Test Cases Executed</td>
               	<#list TestSuite as TC>
      			<#list TC?keys as key>
      			<#if key='Total'>
               <td align="center">
                  ${TC[key]}
               </td>
               	</#if>
     		 	</#list>
      			</#list>
      
            </tr>
            <tr>
               <td>Test Cases Passed</td>
               	<#list TestSuite as TC>
      			<#list TC?keys as key>
      			<#if key='TotalPassed'>
               <td align="center">
                  ${TC[key]}
               </td>
               	</#if>
     		 	</#list>
      			</#list>
            </tr>
            <tr>
               <td>Test Cases Failed</td>
              	<#list TestSuite as TC>
      			<#list TC?keys as key>
      			<#if key='TotalFailed'>
               <td align="center">
                  ${TC[key]}
               </td>
               	</#if>
     		 	</#list>
      			</#list>
            </tr>
            <tr>
               <td>Test Cases NotRun</td>
               <#list TestSuite as TC>
      			<#list TC?keys as key>
      			<#if key='TotalSkipped'>
               <td align="center">
                  ${TC[key]}
               </td>
               	</#if>
     		 	</#list>
      			</#list>
            </tr>
            <tr>
               <td>Total Time</td>
               <td align="center">
                  
               </td>
            </tr>
         
      </table>
      
      <table border="1" width ="80%" align="center">
         <tr bgcolor="#9acd32">
            <th align="middle">Test Case ID</th>
            <th align="middle">Description</th>
            <th align="middle">Status</th>
            <th align="middle">Time</th>
            <th align="middle">ScreenShot</th>
         </tr>
         <#list TestSuite as TC>
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
            <td><img border="0"  align="middle" hspace="2" vspace="2" src="${PassedImage}"></img></td></tr></table></td>
            
            
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Status' && TC[key]=='FAILED'>
            
            
            <td width="20%" align="middle"><table><tr align="middle"><td width="50%">${TC[key]}</td>
            <td><img border="0"  align="middle" hspace="2" vspace="2" src="${FailedImage}"></img></td></tr></table></td>
            
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Status' && TC[key]=='SKIPPED'>
            
           
            <td width="20%" align="middle"><table><tr align="middle"><td width="50%">${TC[key]}</td>
            <td><img border="0"  align="middle" hspace="2" vspace="2" src="${SkippedImage}"></img></td></tr></table></td>
           
            
            
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='Time'>
            <td width="15%" align="middle">${TC[key]}</td>
            </#if>
            </#list>
            
            <#list TC?keys as key>
            <#if key=='ScreenShotPath'>
            <td width="15%" align="middle"><a href=${TC[key]}>ScreenShot</a></td>
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
