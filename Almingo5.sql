SELECT nombre, presupuesto 
FROM Proyecto 
WHERE presupuesto > (SELECT AVG(presupuesto) FROM Proyecto);




