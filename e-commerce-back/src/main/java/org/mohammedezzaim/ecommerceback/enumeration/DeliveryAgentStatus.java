package org.mohammedezzaim.ecommerceback.enumeration;

public enum DeliveryAgentStatus {
    AVAILABLE,        // L'agent est disponible pour prendre des livraisons
    ON_DELIVERY,     // L'agent est actuellement en cours de livraison
    UNAVAILABLE,      // L'agent n'est pas disponible (peut-être en pause ou hors service)
    OFFLINE,          // L'agent est déconnecté
    ON_BREAK          // L'agent est en pause
}
