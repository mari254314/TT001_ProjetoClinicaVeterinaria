/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Animal;
import model.AnimalDAO;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Tratamento;
import model.TratamentoDAO;
import model.VeterinarioDAO;

/**
 *
 * @author maria
 */
public class ConsultaTableModel extends GenericTableModel{
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
     public ConsultaTableModel (List vDados){
        super(vDados, new String[]{"Data", "Comentário", "Veterinario", "Animal", "Tratamento"});
    }//horario, data, comentario, id_veterinario, id_animal, id_tratamento
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
//            case 0:
//                return Integer.class;
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(rowIndex!=0){
            
        Consulta consulta = (Consulta)vDados.get(rowIndex);
        Animal animal;
        Tratamento tratamento;
        
        switch (columnIndex) {
//            case 0:
//                return consulta.getHorario();
            case 0:
                return dateFormat.format(consulta.getData().getTime());
            case 1:
                return consulta.getComentario();
            case 2: 
                return VeterinarioDAO.getInstance().retrieveById(consulta.getId_veterinario());
            case 3: 
                return AnimalDAO.getInstance().retrieveById(consulta.getId_animal());
            case 4:
                return TratamentoDAO.getInstance().retrieveById(consulta.getId_animal());
//                tratamento = TratamentoDAO.getInstance().retrieve(consulta.getId_tratamento());
//                return tratamento.getNome();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        }
        return null;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta)vDados.get(rowIndex);
        
          switch (columnIndex) {
//            case 0:
//                consulta.setHorario((Integer)aValue);
            case 0:
                Calendar cal = Calendar.getInstance();
                try{
                    cal.setTime(dateFormat.parse((String)aValue));
                }catch (ParseException ex){
                    Logger.getLogger(ConsultaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                consulta.setData(cal);
                break;
            case 1:
                 consulta.setComentario((String)aValue);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          ConsultaDAO.getInstance().update(consulta);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if ((columnIndex<2)||(columnIndex>4)){
            return true;
        }else{
            return false;
        }
    }    
}
