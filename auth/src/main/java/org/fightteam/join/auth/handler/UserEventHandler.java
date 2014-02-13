package org.fightteam.join.auth.handler;

import org.fightteam.join.auth.data.models.User;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @HandleAfterCreate
    public void afterCreate(){
        System.out.println("==============HandleAfterCreate===============");
       
    }

    @HandleAfterDelete
    public void afterDelete(){
        System.out.println("==============HandleAfterDelete===============");
    }

    @HandleAfterLinkDelete
    public void afterLinkDelete(){
        System.out.println("==============HandleAfterLinkDelete===============");
    }
    @HandleAfterLinkSave
    public void afterLinkSave(){
        System.out.println("==============HandleAfterLinkSave===============");
    }
    @HandleAfterSave
    public void afterSave(){
        System.out.println("==============HandleAfterSave===============");
    }

    @HandleBeforeCreate
    public void beforeCreate(){
        System.out.println("==============HandleBeforeCreate===============");
        
    }
    @HandleBeforeDelete
    public void beforeDelete(){

        System.out.println("==============HandleBeforeDelete===============");
    }
    @HandleBeforeLinkDelete
    public void beforeLinkDelete(){
        System.out.println("==============HandleBeforeLinkDelete===============");
        
    }
    @HandleBeforeLinkSave
    public void beforeLinkSave(){
        System.out.println("==============HandleBeforeLinkSave===============");
        
    }
    @HandleBeforeSave
    public void beforeSave(){
        System.out.println("==============HandleBeforeSave===============");
        
    }

}
