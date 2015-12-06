package br.ufes.inf.nemo.PortalMedicaoSoftware.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 




import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadView {
     
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload(FileUploadEvent event) {
    	try {  
            UploadedFile arq = event.getFile();  
            InputStream in = new BufferedInputStream(arq.getInputstream());  

            File file = new File("/home/ifrs/img/" + arq.getFileName());  
            //current.setCaminho(file.getAbsolutePath());   
            FileOutputStream fout = new FileOutputStream(file);  
            while (in.available() != 0) {  
                fout.write(in.read());  
            }  

            fout.close();  
            FacesMessage msg = new FacesMessage("O Arquivo ", file.getName() + " salvo.");  
            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }
}