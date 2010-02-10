package org.opens.tanaguru.entity.dao.audit;

import org.opens.tanaguru.entity.audit.Audit;
import org.opens.tanaguru.entity.audit.Content;
import com.adex.sdk.entity.dao.GenericDAO;

/**
 * 
 * @author ADEX
 * @version 1.0.0
 */
public interface ContentDAO extends GenericDAO<Content, Long> {

    /**
     *
     * @param audit
     *            the audit to find from
     * @param uri
     *            the URI to find
     * @return the content
     */
    Content find(Audit audit, String uri);
}
