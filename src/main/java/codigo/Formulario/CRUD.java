package codigo.Formulario;

import codigo.basedeDatos.Model.Usuario;
import codigo.basedeDatos.Service.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUD {


    private JButton buttoncreate;
    private JButton buttondelete;
    private JButton buttonupdate;
    private JLabel lblcrear;
    private JLabel lblemail;
    private JTextField textFieldemail;
    private JTextField textFieldname;
    private JLabel lbldate;
    private JPanel panel;
    private JLabel lblid;
    private JTextField textFieldid;
    private JButton buttonbuscar;


    public CRUD() {



        buttoncreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showConfirmDialog(null,"descrip="+textFieldDescripcion.getText());
                //CREAR

                Usuario usuario = new Usuario();


                usuario.setNombre(textFieldname.getText());
                usuario.setEmail(textFieldemail.getText());
                //usuario.setFechaRegistro(textFieldDescripcion.getText());


                try{
                    new UsuarioService().crearUsuario(usuario);
                    JOptionPane.showMessageDialog(panel,"Usuario creado");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Hay clavos manito"+ex.getMessage());
                }


            }
        });





        buttondelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //ELIMINAR


                int id = textFieldid.getText().isEmpty() ? 0 : Integer.parseInt(textFieldid.getText());


                try{

                    new UsuarioService().eliminarUsuario(id);
                    JOptionPane.showMessageDialog(panel,"Usuario eliminado correctamente");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Hay clavos manito"+ex.getMessage());
                }



            }
        });









        buttonupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ACTUALIZAR

                Usuario usuario = new Usuario();

                usuario.setId(Integer.parseInt(textFieldid.getText()));
                usuario.setNombre(textFieldname.getText().toString());
                usuario.setEmail(textFieldemail.getText().toString());
               // usuario.getFechaRegistro();

                try{

                    new UsuarioService().actualizarUsuario(usuario);
                    JOptionPane.showMessageDialog(panel,"Usuario actualizado correctamente");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Hay clavos manito "+ex.getMessage());
                }
            }
        });







        buttonbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BUSCAR



                int id = textFieldid.getText().isEmpty() ? 0 : Integer.parseInt(textFieldid.getText());

                try{
                    Usuario usuarioencontar = new UsuarioService().obtenerUsuario(id);
                    if(usuarioencontar != null){
                        textFieldid.setText(String.valueOf(usuarioencontar.getId()));
                        textFieldname.setText(usuarioencontar.getNombre());
                        textFieldemail.setText(usuarioencontar.getEmail());

                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el Usuario");
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Hay clavos manito "+ex.getMessage());
                }

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Usuario");
        frame.setContentPane(new CRUD().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }





}
