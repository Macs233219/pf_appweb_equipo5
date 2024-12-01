package modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Post;
import modelo.UsuarioNormal;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-01T05:14:57", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, Post> post;
    public static volatile SingularAttribute<Comentario, Date> fechaHora;
    public static volatile SingularAttribute<Comentario, UsuarioNormal> usuarioNormal;
    public static volatile SingularAttribute<Comentario, Long> id;

}