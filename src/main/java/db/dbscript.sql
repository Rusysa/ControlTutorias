BEGIN TRANSACTION;

CREATE TABLE IF NOT EXISTS "User" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "correo" TEXT NOT NULL UNIQUE,
 "pass" TEXT NOT NULL,
 "role" TEXT NOT NULL CHECK("role" IN ('Admin', 'Tutorado', 'Tutor')),
 "creado_el" TEXT DEFAULT CURRENT_TIMESTAMP,
 "eliminado" INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "Administrador" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "user_id" INTEGER NOT NULL UNIQUE,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("user_id") REFERENCES "User"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Tutor" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "user_id" INTEGER NOT NULL UNIQUE,
 "nombre" TEXT NOT NULL,
 "apellido_paterno" TEXT NOT NULL,
 "apellido_materno" TEXT NOT NULL,
 "telefono" TEXT UNIQUE,
 "direccion" TEXT,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("user_id") REFERENCES "User"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Tutorados" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "user_id" INTEGER UNIQUE,
 "tutor_id" INTEGER,
 "nombre" TEXT NOT NULL,
 "apellido_paterno" TEXT NOT NULL,
 "apellido_materno" TEXT NOT NULL,
 "matricula" TEXT NOT NULL UNIQUE,
 "carrera" TEXT NOT NULL,
 "status" TEXT NOT NULL,
 "telefono" TEXT UNIQUE,
 "telefono_emergencia" TEXT UNIQUE,
 "domicilio" TEXT,
 "fecha_inscripcion" TEXT,
 "afis" INTEGER DEFAULT 0,
 "promedio_general" REAL DEFAULT 0.0,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("tutor_id") REFERENCES "Tutor"("id") ON DELETE SET NULL,
 FOREIGN KEY("user_id") REFERENCES "User"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Periodo" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "ciclo" TEXT NOT NULL,
 "parte" TEXT CHECK("parte" IN ('A', 'B')),
 "es_activo" INTEGER DEFAULT 0,
 "eliminado" INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS "Inscripciones" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "tutorado_id" INTEGER NOT NULL,
 "periodo_id" INTEGER NOT NULL,
 "semestre" INTEGER NOT NULL,
 "estado_pago" INTEGER DEFAULT 0,
 "promedio_semestral" REAL DEFAULT 0.0,
 "num_justificantes" INTEGER DEFAULT 0,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("periodo_id") REFERENCES "Periodo"("id") ON DELETE RESTRICT,
 FOREIGN KEY("tutorado_id") REFERENCES "Tutorados"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Sesiones" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "periodo_id" INTEGER NOT NULL,
 "tutor_id" INTEGER NOT NULL,
 "tipo_sesion" TEXT NOT NULL,
 "fecha" TEXT NOT NULL,
 "tema" TEXT,
 "comentarios" TEXT,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("periodo_id") REFERENCES "Periodo"("id"),
 FOREIGN KEY("tutor_id") REFERENCES "Tutor"("id")
);

CREATE TABLE IF NOT EXISTS "Asistencias" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "sesion_id" INTEGER NOT NULL,
 "inscripcion_id" INTEGER NOT NULL,
 "estado" TEXT CHECK("estado" IN ('Falta', 'Asistio', 'Justificado')),
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("inscripcion_id") REFERENCES "Inscripciones"("id") ON DELETE CASCADE,
 FOREIGN KEY("sesion_id") REFERENCES "Sesiones"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Calificaciones" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "inscripcion_id" INTEGER NOT NULL,
 "valor" REAL NOT NULL,
 "tipo" TEXT,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("inscripcion_id") REFERENCES "Inscripciones"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Documentos" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "tutorado_id" INTEGER NOT NULL,
 "ciclo_escolar_id" INTEGER,
 "doc_tipo" TEXT,
 "ruta" TEXT NOT NULL,
 "nombre_original" TEXT,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("ciclo_escolar_id") REFERENCES "Periodo"("id"),
 FOREIGN KEY("tutorado_id") REFERENCES "Tutorados"("id") ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Reportes" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "tutor_id" INTEGER NOT NULL,
 "tutorado_id" INTEGER NOT NULL,
 "fecha_creacion" TEXT DEFAULT CURRENT_TIMESTAMP,
 "cuerpo_reporte" TEXT,
 "eliminado" INTEGER DEFAULT 0,
 FOREIGN KEY("tutor_id") REFERENCES "Tutor"("id"),
 FOREIGN KEY("tutorado_id") REFERENCES "Tutorados"("id")
);

CREATE TABLE IF NOT EXISTS "HistorialCambios" (
 "id" INTEGER PRIMARY KEY AUTOINCREMENT,
 "tabla_nombre" TEXT NOT NULL,
 "id_valor_modificado" INTEGER NOT NULL,
 "accion" TEXT CHECK("accion" IN ('INSERT', 'UPDATE', 'DELETE')),
 "valor_antiguo" TEXT,
 "nuevo_valor" TEXT,
 "fecha_cambio" TEXT DEFAULT CURRENT_TIMESTAMP,
 "motivo_cambio" TEXT
);

COMMIT;