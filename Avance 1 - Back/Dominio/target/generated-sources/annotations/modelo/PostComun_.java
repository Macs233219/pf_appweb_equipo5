package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Comentario;
import modelo.Usuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-18T10:28:38", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PostComun.class)
public class PostComun_ extends Post_ {

    public static volatile SingularAttribute<PostComun, Usuario> usuario;
    public static volatile ListAttribute<PostComun, Comentario> comentarios;

}