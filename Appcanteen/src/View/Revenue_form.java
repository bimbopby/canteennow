/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.Clock;
import static Controller.DBConfig.con;
import Model.Revenue_total;
import Controller.Revenue_Con;
import Controller.Sanpham_Con;
import Controller.ThongKe_Con;
import Model.GetNV;
import Model.User;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.Revenue;
import Model.ThongKe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author admin
 */
public class Revenue_form extends javax.swing.JFrame {
    GetNV detail;
    private String[] cloumnHeader = new String[]{"Tên hoá đơn", "Nhân viên","Ngày", "Giờ", "Tổng tiền hoá đơn", "Tiền nhận của khách hoàng", "Tiền dư của khách hàng"};
    private DefaultTableModel model;
   // private ArrayList<Revenue> lstRevenue;
 //   private ArrayList<Revenue> lstRevenue_query;
    private ArrayList<ThongKe> lstTK;
    private int selecIndex;
   // Revenue_Con nvconn = new Revenue_Con();
    ThongKe_Con tkcon = new  ThongKe_Con();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form Revenue
     */
   DecimalFormat formatter = new DecimalFormat("###,###,###");   
    public Revenue_form(GetNV d) {
        initComponents();
        setLocationRelativeTo(null);
       // lstRevenue =  nvconn.getListRevenue();
        lstTK = tkcon.getListTK();
        
        initTable();
        initClock();
        showList();
        detail = new GetNV(d);
     
    }
    
    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cloumnHeader);   
        table.setModel(model);
    }
    private void initClock(){
        Clock cl = new Clock(lblClock);
        cl.start();
    }
    private void showList(){
          model.setRowCount(0);
        for (ThongKe s : lstTK) {;
            model.addRow(new Object[]{
                s.getMaHD(),s.getName(), s.getDate(),s.getTime(),s.getTotalMoney(),s.getMoney(),s.getSurplus()
            });
        }
        table.setModel(model);
        label_tonghoadon.setText(tkcon.countRow()+"");
        label_tien.setText(formatter.format(tkcon.tontien())+" "+"VNĐ");
    }
    private void showListdate(){
        model.setRowCount(0);
        String d1 = sdf.format(jDateChooser1.getDate());
        String d2 = sdf.format(jDateChooser2.getDate());
        lstTK = tkcon.getListTKdate(d1, d2);
        for (ThongKe s : lstTK) {;
            model.addRow(new Object[]{
                s.getMaHD(),s.getName(), s.getDate(),s.getTime(),s.getTotalMoney(),s.getMoney(),s.getSurplus()
            });
        }
        table.setModel(model);
        label_tien.setText(formatter.format(tkcon.tontiendate(d1, d2))+" "+"VNĐ");
        label_tonghoadon.setText(model.getRowCount()+"");
    }
 
    
    private long convertedToNumbers(String s){
        String number="";
        String []array=s.replace(","," ").split("\\s");
        for(String i:array){
            number=number.concat(i);
        }
        return Long.parseLong(number);
    }
//    public int countMoney(String sql){
//        long tongTien = 0;
//        String dem;
//        try {
//           
//            PreparedStatement ps = con.prepareStatement(sql);
//         
//            ResultSet rs = ps.executeQuery();
//           
//            while(rs.next()){
//                String []s=rs.getString("total_money").trim().split("\\s");
//                System.out.println("V");
//                tongTien = convertedToNumbers(s[0])+tongTien;
//               
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Sanpham_Con.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return (int) tongTien;
//    }  
        


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_quaylai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        btn_thongke = new javax.swing.JButton();
        btn_xuatfile = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        label_tonghoadon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label_tien = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        table_revenue = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_quaylai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_quaylai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/home (2).png"))); // NOI18N
        btn_quaylai.setText("Quay lại");
        btn_quaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quaylaiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/revenue (1).png"))); // NOI18N
        jLabel1.setText("Thống kê doanh thu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Thống kê từ ngày:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Đến ngày :");

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/loading.png"))); // NOI18N
        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_thongke.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_thongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/money.png"))); // NOI18N
        btn_thongke.setText("Thống kê");
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        btn_xuatfile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_xuatfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/file-management.png"))); // NOI18N
        btn_xuatfile.setText("Xuất file");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("(+) Tổng số hoá đơn bán ra :");

        label_tonghoadon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_tonghoadon.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("(+) Tổng tiền :");

        label_tien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_tien.setText("0");

        lblClock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_revenue.setViewportView(table);

        jDateChooser2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser2KeyReleased(evt);
            }
        });

        jButton1.setText("Biểu đồ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btn_quaylai))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_thongke)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xuatfile)
                        .addContainerGap())))
            .addComponent(table_revenue)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_tonghoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_tien, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_quaylai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGap(6, 6, 6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_xuatfile, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(label_tonghoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_tien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(table_revenue, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        // TODO add your handling code here:
//        String sqlRevenue="SELECT * FROM revenue WHERE date BETWEEN '"+new java.sql.Date(jDate_from.getDate().getTime())+"' AND '"+new java.sql.Date(jDate_to.getDate().getTime())+"'";
//        lstRevenue_query =  nvconn.getListRevenue_query(sqlRevenue);
//        showList1();
//        String sql = "select count(*) from revenue  WHERE date BETWEEN '"+new java.sql.Date(jDate_from.getDate().getTime())+"' AND '"+new java.sql.Date(jDate_to.getDate().getTime())+"'";
//        String sql_money = "select total_money from revenue  WHERE date BETWEEN '"+new java.sql.Date(jDate_from.getDate().getTime())+"' AND '"+new java.sql.Date(jDate_to.getDate().getTime())+"'";
//        Integer row= countRow(sql);
//        Integer tongtien= countMoney(sql_money);
//        DecimalFormat formatter = new DecimalFormat("###,###,###");
//        label_tonghoadon.setText((String.valueOf(row)));
//        label_tien.setText(formatter.format(tongtien)+" "+"VND");
          showListdate();
          
           
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void btn_quaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quaylaiActionPerformed
        // TODO add your handling code here:
        new menu0(detail).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_quaylaiActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
//        DefaultTableModel model123 = (DefaultTableModel) table_revenue.
//        table_revenue.
        lstTK = tkcon.getListTK(); 
        showList();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void jDateChooser2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser2KeyReleased
        // TODO add your handling code here:
        showListdate();
    }//GEN-LAST:event_jDateChooser2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new StaticForm().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  GetNV   detail = new GetNV();
                new Revenue_form(detail).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_quaylai;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JButton btn_xuatfile;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_tien;
    private javax.swing.JLabel label_tonghoadon;
    private javax.swing.JLabel lblClock;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane table_revenue;
    // End of variables declaration//GEN-END:variables
}
