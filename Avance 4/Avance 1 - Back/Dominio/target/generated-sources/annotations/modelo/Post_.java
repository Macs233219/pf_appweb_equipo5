package modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Comentario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-01T05:14:57", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, Date> fechaHoraEdicion;
    public static volatile SingularAttribute<Post, String> contenido;
    public static volatile SingularAttribute<Post, Date> fechaHoraCreacion;
    public static volatile SingularAttribute<Post, String> titulo;
    public static volatile SingularAttribute<Post, Long> id;
    public static volatile SingularAttribute<Post, String> portada;
    public static volatile ListAttribute<Post, Comentario> comentarios;

}