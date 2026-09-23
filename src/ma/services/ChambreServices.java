/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.services;

import java.util.List;

import ma.dao.IDao;
import exemple1.Chambre;
import exemple1.Etat;
import exemple1.Hotel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 *
 * @author ouiam
 */
public class ChambreServices implements IDao<Chambre> {

    @Override
    public boolean create(Chambre o) {

        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.save(o);

            tx.commit();
            etat = true;

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return etat;
    }

    @Override
    public boolean delete(Chambre o) {

        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.delete(o);

            tx.commit();
            etat = true;

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return etat;
    }

    @Override
    public boolean update(Chambre o) {

        Session session = null;
        Transaction tx = null;
        boolean etat = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            session.update(o);

            tx.commit();
            etat = true;

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return etat;
    }

    @Override
    public Chambre findById(long id) {

        Session session = null;
        Transaction tx = null;
        Chambre chambre = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            chambre = (Chambre) session.get(Chambre.class, id);

            tx.commit();

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return chambre;
    }

    @Override
    public List<Chambre> findAll() {

        Session session = null;
        Transaction tx = null;
        List<Chambre> chambres = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            chambres = session.createQuery("from Chambre").list();

            tx.commit();

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return chambres;
    }

    // Afficher les chambres par hôtel
    public List<Chambre> findByHotel(Hotel hotel) {

        Session session = null;
        Transaction tx = null;
        List<Chambre> chambres = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            chambres = session.createQuery(
                    "from Chambre where hotel = :hotel"
            )
            .setParameter("hotel", hotel)
            .list();

            tx.commit();

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return chambres;
    }

    // Rechercher les chambres par état et par prix
    public List<Chambre> findByEtatAndPrix(Etat etat, double prix) {

        Session session = null;
        Transaction tx = null;
        List<Chambre> chambres = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            chambres = session.createQuery(
                    "from Chambre where etat = :etat and prix <= :prix"
            )
            .setParameter("etat", etat)
            .setParameter("prix", prix)
            .list();

            tx.commit();

        } catch (HibernateException ex) {

            if (tx != null) {
                tx.rollback();
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return chambres;
    }
}