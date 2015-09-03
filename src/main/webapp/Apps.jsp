<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">

    <logic:empty scope="session" name="username">
        <jsp:forward page="/index.jsp"/>
    </logic:empty>
    <body>
        <div class="container">
        <form action="/Strutsku/Apps.do" method="GET">
            <center>
                <a href="/Strutsku/logout.do" >Log Out</a>
                <table border="0">
                    <tr><td>nim :</td><td><input type="text" class="input-append" name="nim" id="nim"/></td></tr>
                    <tr><td>nama :</td><td><input type="text" class="input-append" name="nama" id="nama"/></td></tr>

                    <center><tr><td> <canter><input class="btn btn-primary" type="submit" name="Action" value="Simpan" id="Simpan"></canter></td><center>
                            <td> <input type="reset" class="btn btn-primary"value="Reset"></td></center><td>
                        <canter><input class="btn btn-primary" type="submit" name="Action" value="Cari" id="Cari">
                            </td></tr>
                            </table>
                            </center>        
                            <table class="table table-bordered" width="558" border="0" align="center">
                                <tr>
                                    <th width="136" bgcolor="#CCCCCC" scope="col" >NIP</th>
                                    <th width="204" bgcolor="#CCCCCC" scope="col">Nama</th>
                                    <th width="204" bgcolor="#CCCCCC" scope="col">Rule</th>
                                </tr>
                                <logic:notEmpty name="lis">
                                    <logic:iterate id="opoaewes" name="lis">
                                        <tr>
                                            <th scope="col">
                                                <bean:write name="opoaewes" property="record1"/> 
                                            </th>
                                            <th scope="col">
                                                <bean:write name="opoaewes" property="record2"/>                                 
                                            </th>
                                            <th scope="col">
                                                <a href="delete.do?id=<bean:write name="opoaewes" property="record1"/>">Edit</a>
                                                | <a href="delete.do?id=<bean:write name="opoaewes" property="record1"/>">Delete</a>
                                            </th>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </table>
                            </form>
        </div>
                            </body>
                            </html>