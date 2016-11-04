<%@page import="Bussines.AsignarBussines"%>
<%@page import="Entidad.SubSector"%>
<%@page import="Entidad.SubSector"%>
<%@page import="java.util.LinkedList"%>
<select name="comboSubSectorAsignar">
    <%String id=request.getParameter("combo");
    
     LinkedList<SubSector> listSubSector=AsignarBussines.ListaSubSector(id);
     for(int i=0;i<listSubSector.size();i++){
         out.println("<option value='"+listSubSector.get(i).getId()+"'>");
         out.println(listSubSector.get(i).getNombre()+" "+listSubSector.get(i).getId());
         out.println("</option>");
     }
    

    %>
</select>